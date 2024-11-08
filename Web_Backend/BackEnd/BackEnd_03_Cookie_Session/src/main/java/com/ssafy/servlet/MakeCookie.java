package com.ssafy.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MakeCookie
 */
@WebServlet("/make")
public class MakeCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String key = request.getParameter("key");
		String value = request.getParameter("value");
		
		//쿠키 생성
		//한글 안됨
		Cookie cookie = new Cookie(key,value);
		
		//유효시간(만료 단위) : 초단위
		cookie.setMaxAge(60);//1분 동안 쿠키 유효
		
		//쿠키 삭제 메서드는 따로 없음
		//cookie.setMaxAge(0); -> 쿠키 삭제하는 방법
		
		//사용자에게 어떻게 돌려줄까
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath()+"/02_CookieResult.jsp");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		req.getCookies();
		
//		//반목문 돌리며
//		for(Cookie c: ) {
//			if(getName 같다면) {
//				해당 쿠키의 유효기간을 지워라
//			}
//		}
	}


}
