package com.lastcompany.haiwaicang.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class RedirectController {

//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String toIndex(HttpSession session){
//		return "/production/index";
//	}

//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String resetpassword(HttpSession session, HttpServletRequest request, HttpServletResponse response){
//		//return "/login.html";
//		//response.setContentType("text/html; charset=utf-8");
//
//		try {
//			//response.sendRedirect(request.getContextPath()+"/login.html");//返回登录页
//			response.sendRedirect("/login.html");
//		}
//		catch (Exception e)
//		{}
//
//
//		return "";
//	}

//	@RequestMapping(value = "/",method=RequestMethod.GET)
//	public String cs(HttpSession session,HttpServletRequest req, HttpServletResponse resp) {
//
//		//return "index.html";
//		try{
//		//	resp.sendRedirect("http://baidu.com/downloadRequestElecCont.action?contNo="+1);
//		}
//		catch (Exception e)
//		{
//
//		}
//		return "/login.html";
//
//	}



	@RequestMapping(value="/",method=RequestMethod.GET)
	public String login(HttpSession session){
		return "/index.html";
	}
	@RequestMapping(value="/401",method=RequestMethod.GET)
	public String to401(HttpSession session){
		return "/401";
	}

	@RequestMapping(value="/404",method=RequestMethod.GET)
	public String to404(HttpSession session){
		return "/404";
	}

	@RequestMapping(value="/405",method=RequestMethod.GET)
	public String to405(HttpSession session){
		return "/405";
	}

	@RequestMapping(value="/500",method=RequestMethod.GET)
	public String to500(HttpSession session){
		return "/500";
	}

	@RequestMapping(value="/error",method=RequestMethod.GET)
	public String toerror(HttpSession session){
		return "/error";
	}



}
