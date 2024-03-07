package com.ssafy.myservlet;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
//지금은 순수한 class파일
//얘를 servlet으로 만들고 싶으면
//이미 만들어져 있는 servlet을 등록

public class MyServlet2 extends GenericServlet {

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		//서비스(요청과 응답 처리)만 구현하면된다.
		
	}

	


}
