package com.lastcompany.haiwaicang.interceptor;

import com.lastcompany.haiwaicang.constant.Constant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String URI = request.getRequestURI();
		String projectName = request.getContextPath();
		URI = URI.substring(projectName.length());
		if(request.getQueryString()!=null)
		{
			URI+="?"+request.getQueryString();
		}

		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute(Constant.SESSION_ADMIN_USERID);
		if (userId == null) {
			response.sendRedirect(request.getContextPath()+"/admin/login?backURL="+URI);//返回登录页
			return false;
		}


		return super.preHandle(request, response, handler);
	}

}
