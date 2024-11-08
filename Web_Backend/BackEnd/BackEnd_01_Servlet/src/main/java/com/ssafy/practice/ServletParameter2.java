package com.ssafy.practice;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;


@WebServlet("/ServletParameter2")
public class ServletParameter2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String text = req.getParameter("text");
		int number = Integer.parseInt(req.getParameter("number"));
		String campus = req.getParameter("campus");
		String[] fruit = req.getParameterValues("fruit");
		String programming_language = req.getParameter("programming-language");
		System.out.println(text);
		System.out.println(number);
		System.out.println(campus);
		System.out.println(Arrays.toString(fruit));
		System.out.println(programming_language);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String text = req.getParameter("text");
		int number = Integer.parseInt(req.getParameter("number"));
		String campus = req.getParameter("campus");
		String[] fruit = req.getParameterValues("fruit");
		String programming_language = req.getParameter("programming-language");
		System.out.println(text);
		System.out.println(number);
		System.out.println(campus);
		System.out.println(Arrays.toString(fruit));
		System.out.println(programming_language);
		
	}

}
