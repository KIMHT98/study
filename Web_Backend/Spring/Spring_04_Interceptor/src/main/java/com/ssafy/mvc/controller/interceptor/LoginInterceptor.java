package com.ssafy.mvc.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		//로그인이 안되어 있으면 등록페이지로 안가고 로그인창으로 넘어감
		if(session.getAttribute("id")==null) {
			response.sendRedirect("login");
			return false;
		}
		//로그인 되어있으면 정상 실행
		return true;
	}
	

}
