package com.lastcompany.haiwaicang.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class RedirectController {

//	@RequestMapping(value="/",method=RequestMethod.GET)
//	public String toIndex(HttpSession session){
//		return "/production/index";
//	}

//	@RequestMapping(value="/member/resetpassword",method=RequestMethod.GET)
//	public String resetpassword(HttpSession session){
//		return "/member/resetpassword.html";
//	}



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
