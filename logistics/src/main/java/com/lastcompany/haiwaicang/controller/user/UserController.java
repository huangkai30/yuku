package com.lastcompany.haiwaicang.controller.user;


import com.lastcompany.haiwaicang.dao.IHandleRecordsDao;
import com.lastcompany.haiwaicang.entity.HandleRecords;
import com.lastcompany.haiwaicang.entity.User;
import com.lastcompany.haiwaicang.entity.UserLogin;
import com.lastcompany.haiwaicang.service.IHandleRecordsService;
import com.lastcompany.haiwaicang.service.IUserLoginService;
import com.lastcompany.haiwaicang.service.IUserService;
import com.lastcompany.haiwaicang.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.lastcompany.haiwaicang.constant.*;

import java.util.Date;


@RestController
@RequestMapping("user")
public class UserController {
//    //    private final Logger logger = Logger.getLogger(HouseController.class);
    @Autowired
    private IUserService userService;

    @Autowired
    private IUserLoginService userLoginService;

    @Autowired
    private IHandleRecordsService handleRecordsService;

    @RequestMapping(value = "/self", method = RequestMethod.POST)
    public Object self(HttpServletRequest request, HttpSession session) {
        Result result = new Result();
        try {


            User user = userService.getById(Integer.parseInt(session.getAttribute(Constant.SESSION_MEMBER_USERID).toString()));
            result.setData(user);
//

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
        result.setMsgCode(ErrorCode.SUCCESS_CODE);
        return result;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(HttpServletRequest request, HttpSession session, @RequestParam(value = "password") String password,
                        @RequestParam(value = "username") String userName) {
        Result result = new Result();
        try {


            User user = userService.login(userName, password);
//            MemberLoginLog log = new MemberLoginLog();
//            log.setMemberId(member.getId());
//            String ip = request.getHeader("x-forwarded-for");
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("X-Real-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getHeader("WL-Proxy-Client-IP");
//            }
//            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//                ip = request.getRemoteAddr();
//            }
//            log.setIp(ip);
//            memberLoginLogService.add(log);
            result.setMsgCode(ErrorCode.SUCCESS_CODE);
            session.setAttribute(Constant.SESSION_MEMBER_USERID, user.getId());
            session.setAttribute(Constant.SESSION_MEMBER_USERNAME, user.getUserName());
            UserLogin userLogin=new UserLogin();
            userLogin.setUserId(user.getId());
            userLogin.setUserName(user.getUserName());
            userLogin.setType(Constant.LOGIN_TYPE_USER);
            Date date=new Date();
            userLogin.setDateCreated(date);
            userLogin.setDateModified(date);
            userLoginService.add(userLogin);
//            session.setAttribute(Constant.SESSION_MEMBER_PHONE, member.getMobileCountryCode1()+member.getMobile1());
//            session.setAttribute(Constant.SESSION_MEMBER_EMAIL, member.getEmail());
//            session.setAttribute(Constant.LOGIN_ACCOUNT_TYPE, 2);

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
        result.setMsgCode(ErrorCode.SUCCESS_CODE);
        return result;
    }



    @RequestMapping(value = "/reset_pw", method = RequestMethod.POST)
    public Object reset_pw(HttpServletRequest request, HttpSession session, @RequestParam(value = "password") String password,
                        @RequestParam(value = "old_password") String old_password) {
        Result result = new Result();
        try {
            User user = userService.getById(Integer.valueOf(session.getAttribute(Constant.SESSION_MEMBER_USERID).toString()));

              if(user!=null)
              {
                  user=userService.resetpw(user.getId(),old_password,password);
                  if(user==null)
                  {
                      result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                  }
                  else
                  {
                      HandleRecords records=new HandleRecords();
                      records.setDescription("reset password : "+session.getAttribute(Constant.SESSION_MEMBER_USERNAME).toString());
                      records.setType(Constant.HANDLE_RECORDS_TYPE_5);
                      records.setUserId(user.getId());

                      Date date=new Date();
                      records.setDateCreated(date);
                      records.setDateModified(date);

                      handleRecordsService.add(records);
                  }


              }
              else
              {
                  result.setMsgCode(ErrorCode.SHOW_EXCEPTION);
                 // result.setMsg(e.getMessage());
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
        result.setMsgCode(ErrorCode.SUCCESS_CODE);
        return result;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Object logout(HttpSession session) {
        session.removeAttribute(Constant.SESSION_MEMBER_USERID);
        session.removeAttribute(Constant.SESSION_MEMBER_USERNAME);


        session.removeAttribute(Constant.SESSION_MEMBER_PHONE);
        session.removeAttribute(Constant.SESSION_MEMBER_EMAIL);
        session.removeAttribute(Constant.LOGIN_ACCOUNT_TYPE);
        session.removeAttribute(Constant.KAPTCHA_SESSION_MEMBER_KEY);
        session.invalidate();
        Result result = new Result();
        result.setMsgCode(ErrorCode.SUCCESS_CODE);
        return result;
    }

//    @RequestMapping("/defaultKaptcha")
//    public void defaultKaptcha(HttpSession session, HttpServletResponse httpServletResponse) throws Exception{
//        byte[] captchaChallengeAsJpeg = null;
//        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
//        try {
//            //生产验证码字符串并保存到session中
//            String createText = defaultKaptcha.createText();
//            session.setAttribute(Constant.KAPTCHA_SESSION_MEMBER_KEY, createText);
//            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
//            BufferedImage challenge = defaultKaptcha.createImage(createText);
//            ImageIO.write(challenge, "jpg", jpegOutputStream);
//        } catch (IllegalArgumentException e) {
//            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
//            return;
//        }
//
//        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
//        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
//        httpServletResponse.setHeader("Cache-Control", "no-store");
//        httpServletResponse.setHeader("Pragma", "no-cache");
//        httpServletResponse.setDateHeader("Expires", 0);
//        httpServletResponse.setContentType("image/jpeg");
//        ServletOutputStream responseOutputStream =
//                httpServletResponse.getOutputStream();
//        responseOutputStream.write(captchaChallengeAsJpeg);
//        responseOutputStream.flush();
//        responseOutputStream.close();
//    }



}