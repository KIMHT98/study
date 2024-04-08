package com.ssafy.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//얘를 servlet으로 만들고 싶으면
//이미 만들어져 있는 servlet을 등록
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/main2")
public class MyServlet5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답과 관련
		//내가 보낼 응답에다가 텍스트로 쓰면 html로 바꿔서 생각해라
		//인코딩 방식도 utf8로 설정
		response.setContentType("text/html;characterset=UTF-8");
		//리스폰에다가 쓰고 싶은 내용 써주는 객체
		PrintWriter writer = response.getWriter();
		
		//리스폰에다가 이런 내용 쓰겠다.
		writer.write("""
		<html>
		  <head><title>Hello! SSAFY!</title></head>
		  <body>
		    <h1>Hello! MyServlet5!</h1>
		  </body>
		</html>
		""");
	}

		
	}

	




