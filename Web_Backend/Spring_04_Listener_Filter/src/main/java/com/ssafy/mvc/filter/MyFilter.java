package com.ssafy.mvc.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class MyFilter extends HttpFilter implements Filter {
	public FilterConfig filterConfig;
	//필터 초기화 하는 과정
	public void init(FilterConfig fConfig) throws ServletException {
		//얘가 가장 먼저 실행되는 메소드니깐
		//얘가 실행됬을 때 얘의 설정들을 내가 갖고 있는 변수에다 초기화하겠다.
		this.filterConfig = fConfig;
	}
    //필터 종료될 때
	public void destroy() {
	}
	//필터 동작과정
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//서버에 가기전 필요한 코드 작성//
		
		System.out.println("서블릿 전1");
		//다음 필터로 전달
		//다음 필터가 없으면 서블릿으로 간다
		String encoding = this.filterConfig.getInitParameter("encoding");
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		
		//사용자에게 가기전 필요한 코드 작성//
		
		System.out.println("서블릿 후1");
	}


}
