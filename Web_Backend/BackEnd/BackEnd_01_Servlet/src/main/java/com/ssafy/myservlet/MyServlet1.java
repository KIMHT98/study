package com.ssafy.myservlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
//지금은 순수한 class파일
//얘를 servlet으로 만들고 싶으면
//이미 만들어져 있는 servlet을 등록

public class MyServlet1 implements Servlet {

	@Override
	public void destroy() {
		//Servlet이 소멸할 때
		
	}

	@Override
	public ServletConfig getServletConfig() {
		//Servlet 설정 객체를 반환
		return null;
	}

	@Override
	public String getServletInfo() {
		//Servlet정보를 반환하겠다.
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		//파라미터로 넘겨 받은 Servlet 설정 파일을 가지고 초기화 하는 작업
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		//요청과 응답을 처리하는 일
		
	}


}
