package com.lastcompany.haiwaicang.controller.user;


import com.lastcompany.haiwaicang.constant.*;
import com.lastcompany.haiwaicang.dao.IProductDao;
import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.Product;
import com.lastcompany.haiwaicang.entity.SearchObject;
import com.lastcompany.haiwaicang.service.IHandleRecordsService;
import com.lastcompany.haiwaicang.service.IProductService;
import com.lastcompany.haiwaicang.service.IUserLoginService;
import com.lastcompany.haiwaicang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("user/product")
public class ProductController {
//    //    private final Logger logger = Logger.getLogger(HouseController.class);
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IHandleRecordsService handleRecordsService;

    @Autowired
    private IProductService productService;




    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(HttpServletRequest request, @RequestBody Product product,HttpSession session, BindingResult bindingResult){
        Result result = new Result();
        product.setLastpersion(session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
        if (bindingResult.hasErrors()) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
              int i=   productService.add(product);

              if(i==0)
              {
                  result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
              }
              else
              {
                  HandleRecords records=new HandleRecords();
                  records.setUserId(Integer.parseInt(session.getAttribute(Constant.SESSION_MEMBER_USERID).toString()));
                  records.setUserName(session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
                  records.setType(Constant.HANDLE_RECORDS_TYPE_0);
                  records.setDescription("Add Product. sku: "+product.getSku());

                  handleRecordsService.add(records);
                  result.setMsgCode(ErrorCode.SUCCESS_CODE);
              }
            } catch (ErrorMessageException e) {
                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(e.getMessage());
            } catch (Exception e) {


                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(ErrorMessage.SYSTEM_ERROR);
            }
        }
        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object update(HttpServletRequest request,@RequestBody Product product,HttpSession session,  BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
                product.setLastpersion(session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
                int i=   productService.update(product);
                if(i==0)
                {
                    result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                }
                else
                {


                    Product pr=productService.getById(product.getId());
                    HandleRecords records=new HandleRecords();
                    records.setUserId(Integer.parseInt(session.getAttribute(Constant.SESSION_MEMBER_USERID).toString()));
                    records.setUserName(session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
                    records.setType(Constant.HANDLE_RECORDS_TYPE_3);

                    records.setDescription("Update Product. sku: "+pr.getSku());

                    handleRecordsService.add(records);
                    result.setMsgCode(ErrorCode.SUCCESS_CODE);
                }
            } catch (ErrorMessageException e) {
                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(e.getMessage());
            } catch (Exception e) {

                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(ErrorMessage.SYSTEM_ERROR);
            }
        }
        return result;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Object delete(HttpSession session,HttpServletRequest request, @RequestParam(value = "ids[]") List<String> ids){



        Result result = new Result();
        try{

//            List<String> ids=new ArrayList<>();
//            ids.add(id);
            try {
              if(ids!=null&&ids.size()>0)
              {

                  String skus="";
                  for(int i=0;i<ids.size();i++)
                  {
                    Product re=  productService.getById(Integer.parseInt(ids.get(i)));
                    if(re!=null)
                    {
                        if(skus.equals(""))
                        {
                            skus=re.getSku();
                        }
                        else
                        {
                            skus+="; "+re.getSku();
                        }
                    }
                  }

                  for(int i=0;i<ids.size();i++)
                  {
                      productService.delete(Integer.parseInt(ids.get(i)));
                  }


                  HandleRecords records=new HandleRecords();
                  records.setUserId(Integer.parseInt(session.getAttribute(Constant.SESSION_MEMBER_USERID).toString()));
                  records.setUserName(session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
                  records.setType(Constant.HANDLE_RECORDS_TYPE_6);
                  records.setDescription("delete Product. : "+skus);

                  handleRecordsService.add(records);



                  result.setMsgCode(ErrorCode.SUCCESS_CODE);
              }

            } catch (ErrorMessageException e) {
                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(e.getMessage());
            } catch (Exception e) {

                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(ErrorMessage.SYSTEM_ERROR);
            }

    } catch (ErrorMessageException e) {
        result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
        result.setMsg(e.getMessage());
        //  setSecurityCodeNumberAll(result,session);
        // logger.error(e);
    } catch (Exception e) {
        result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
        result.setMsg(ErrorMessage.SYSTEM_ERROR);
        // setSecurityCodeNumberAll(result,session);
        //   logger.error(e);
    }

        return result;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public Object getbyid(HttpServletRequest request, @RequestParam(value = "id") int id){
        Result result = new Result();

            try {
               Product re= productService.getById(id);
                if(re==null)
                {
                    result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                }
                else
                {
                    result.setMsgCode(ErrorCode.SUCCESS_CODE);
                    result.setData(re);
                }

            } catch (ErrorMessageException e) {
                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(e.getMessage());
            } catch (Exception e) {

                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(ErrorMessage.SYSTEM_ERROR);
            }


        return result;
    }

    @RequestMapping(value = "/getbysku", method = RequestMethod.POST)
    public Object getbysku(HttpServletRequest request, @RequestParam(value = "sku") String sku){
        Result result = new Result();

        try {
            Product re= productService.getBySku(sku);
//            if(re==null)
//            {
//                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
//            }
//            else
//            {
//                result.setMsgCode(ErrorCode.SUCCESS_CODE);
//                result.setData(re);
//            }
            result.setMsgCode(ErrorCode.SUCCESS_CODE);
            result.setData(re);
        } catch (ErrorMessageException e) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(e.getMessage());
        } catch (Exception e) {

            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(ErrorMessage.SYSTEM_ERROR);
        }


        return result;
    }



    @RequestMapping(value = "/input_inventory", method = RequestMethod.POST)
    public Result input_inventory(HttpSession session,HttpServletRequest request, @RequestParam(value = "sku") String sku, @RequestParam(value = "quantity") int quantity){
        Result result = new Result();

        try {




           // Product re= productService.getBySku(sku);
            Product re= productService.addInventory(sku,quantity);




            HandleRecords records=new HandleRecords();
            records.setUserId(Integer.parseInt(session.getAttribute(Constant.SESSION_MEMBER_USERID).toString()));
            records.setUserName(session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
            records.setType(Constant.HANDLE_RECORDS_TYPE_1);
            records.setDescription("Input Product, add quantity: "+quantity);

            handleRecordsService.add(records);

//            if(re==null)
//            {
//                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
//            }
//            else
//            {
//                result.setMsgCode(ErrorCode.SUCCESS_CODE);
//                result.setData(re);
//            }
            result.setMsgCode(ErrorCode.SUCCESS_CODE);
            result.setData(re);
        } catch (ErrorMessageException e) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(e.getMessage());
        } catch (Exception e) {

            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(ErrorMessage.SYSTEM_ERROR);
        }


        return result;
    }



    @RequestMapping(value = "/remove_inventory", method = RequestMethod.POST)
    public Result remove_inventory(HttpSession session,HttpServletRequest request, @RequestParam(value = "sku") String sku, @RequestParam(value = "quantity") int quantity){
        Result result = new Result();

        try {


            Product re= productService.removeInventory(sku,quantity);

            HandleRecords records=new HandleRecords();
            records.setUserId(Integer.parseInt(session.getAttribute(Constant.SESSION_MEMBER_USERID).toString()));
            records.setUserName(session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
            records.setType(Constant.HANDLE_RECORDS_TYPE_1);
            records.setDescription("Output Product, reduce quantity: "+quantity);

            handleRecordsService.add(records);

            result.setMsgCode(ErrorCode.SUCCESS_CODE);
            result.setData(re);
        } catch (ErrorMessageException e) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(e.getMessage());
        } catch (Exception e) {

            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(ErrorMessage.SYSTEM_ERROR);
        }


        return result;
    }



    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Object search(HttpServletRequest request, @RequestParam(value = "id", required=false) String id,
                         @RequestParam(value = "keyword", required=false) String keyword,
                         @RequestParam(value = "rows", required=false,defaultValue="10") int rows,
                         @RequestParam(value = "page", required=false,defaultValue="1") int page,
                         @RequestParam(value = "sidx", required=false) String sidx,
                         @RequestParam(value = "sord", required=false) String sord){
        Result result = new Result();

            try {
                SearchObject records= productService.search(id,keyword,rows,page,sidx,sord);

                result.setMsgCode(ErrorCode.SUCCESS_CODE);
                result.setData(records);

            } catch (ErrorMessageException e) {
                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(e.getMessage());
            } catch (Exception e) {

                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(ErrorMessage.SYSTEM_ERROR);
            }


        return result;
    }
}


