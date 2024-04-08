package com.ssafy.proxy;

import java.util.Random;

public class Programmer {
	//필드 생략
	
	//AOP는 어차피 메서드에 동작을 시키는 것이기 때문
	//프로그래머의 일상
	public void coding() {
		System.out.println("컴퓨터 부팅");//이전에 수행해야할 친구
		try {
			System.out.println("열심히 코딩");//핵심 관심 사항
			if(new Random().nextBoolean()) {
				throw new OuchException();
			}
			System.out.println("Git에 Push");//이상없이 마무리가 되었을 
		}catch(OuchException e) {
			e.handleException();
			System.out.println("조퇴한다."); //예외 발생
		}finally {
			System.out.println("하루를 마무리");//모든게 마무리가 되었을 때
		}
		
	}
}
