package com.lastcompany.haiwaicang.interceptor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lastcompany.haiwaicang.constant.Constant;
import com.lastcompany.haiwaicang.constant.ErrorCode;
import com.lastcompany.haiwaicang.constant.Result;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLoginInterceptor extends HandlerInterceptorAdapter {

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
		Integer userId = (Integer)session.getAttribute(Constant.SESSION_MEMBER_USERID);
		if (userId == null) {
			Result result = new Result();
			result.setMsg("Please login firstly..");
			result.setMsgCode(ErrorCode.NEED_LOGIN);
//			response.
			response.setContentType("application/json; charset=utf-8");

			response.sendRedirect(request.getContextPath()+"/member/login?backURL="+URI);//返回登录页
			//response.sendRedirect(result.toString());



//			JSONObject responseJSONObject = JSONObject.(result);
//					.fromObject(responseObject);
//			response.setContentType("application/json; charset=utf-8");
//			//response.sendRedirect(result.toString());
//			PrintWriter out = null;
//			try {
//				out = response.getWriter();
//				out.append(responseJSONObject.toString());
//				logger.debug("返回是\n");
//				logger.debug(responseJSONObject.toString());
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				if (out != null) {
//					out.close();
//				}
//			}
//
//



			return false;
		}


		return super.preHandle(request, response, handler);
	}

}
