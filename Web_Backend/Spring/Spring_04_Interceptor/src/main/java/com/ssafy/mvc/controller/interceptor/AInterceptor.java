package com.ssafy.mvc.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//인터셉터는 핸들러 인터셉터를 구현한 것
public class AInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// boolean형태의 반환타입
		// true면 진행 false면 종료
		System.out.println("A : preHandle");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//정상 수행 후 실행, 예외 발생 시 미실행
		System.out.println("A : postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//view가 전달된 후 실행 -> 무조건 실행 -> 예왹 미 발생시 객체는 null로 초기화
		System.out.println("A : afterCompletion");

	}
}
