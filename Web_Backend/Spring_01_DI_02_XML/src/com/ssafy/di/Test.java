package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationcontext.xml");
		
		System.out.println("1_______________");
		Programmer p =(Programmer) context.getBean("programmer");
		//기본 설정은 getean할 때 생성하는 것이 아닌 컨테이너를 빌드할 때 빈들이 생성된다.
		Desktop d = context.getBean("desktop",Desktop.class);
		p.setComputer(d);
		System.out.println("2_______________");
		p.coding();
		
		Desktop d2 = context.getBean("desktop",Desktop.class);
		System.out.println(d==d2);//true -> 컨테이너는 객체를 싱글턴으로 관리한다.
	
	}
}
