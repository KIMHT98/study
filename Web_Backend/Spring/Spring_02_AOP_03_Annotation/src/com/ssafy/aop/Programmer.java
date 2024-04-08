package com.ssafy.aop;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Programmer implements Person {
	// 필드 생략

	// AOP는 어차피 메서드에 동작을 시키는 것이기 때문
	// 프로그래머의 일상
	public int coding() {
		System.out.println("열심히 코딩");// 핵심 관심 사항
		if(new Random().nextBoolean())
			throw new OuchException();
		return (int)(Math.random()*100)+1;
	}
}
