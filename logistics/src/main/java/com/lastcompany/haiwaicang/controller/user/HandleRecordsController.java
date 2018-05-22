package com.lastcompany.haiwaicang.controller.user;


import com.lastcompany.haiwaicang.constant.*;
import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.User;
import com.lastcompany.haiwaicang.entity.UserLogin;
import com.lastcompany.haiwaicang.service.IHandleRecordsService;
import com.lastcompany.haiwaicang.service.IUserLoginService;
import com.lastcompany.haiwaicang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("handle_records")
public class HandleRecordsController {
//    //    private final Logger logger = Logger.getLogger(HouseController.class);
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IHandleRecordsService handleRecordsService;




    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(HttpServletRequest request,@RequestBody HandleRecords handleRecords, BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
              int i=   handleRecordsService.add(handleRecords);
              if(i==0)
              {
                  result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
              }
              else
              {
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
    public Object update(HttpServletRequest request,@RequestBody HandleRecords handleRecords, BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
                int i=   handleRecordsService.update(handleRecords);
                if(i==0)
                {
                    result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                }
                else
                {
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
    public Object delete(HttpServletRequest request, @RequestParam(value = "ids[]") List<String> ids, BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
              if(ids!=null&&ids.size()>0)
              {
                  for(int i=0;i<ids.size();i++)
                  {
                      handleRecordsService.delete(Integer.parseInt(ids.get(i)));
                  }
              }
            } catch (ErrorMessageException e) {
                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(e.getMessage());
            } catch (Exception e) {

                result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                result.setMsg(ErrorMessage.SYSTEM_ERROR);
            }
        }
        result.setMsgCode(ErrorCode.SUCCESS_CODE);
        return result;
    }

    @RequestMapping(value = "/getbyid", method = RequestMethod.POST)
    public Object getbyid(HttpServletRequest request, @RequestParam(value = "id") int id, BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
            result.setMsg(bindingResult.getAllErrors().get(0).getDefaultMessage());
        } else {
            try {
               HandleRecords re= handleRecordsService.getById(id);
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
        }

        return result;
    }

}