package com.ssafy.di2_객체의존성제거;

public class Test {
	public static void main(String[] args) {
		//의존관계역전 맛보기
		
		//스프링 컨테이너가 이런것을 해줌
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
		Programmer p = new Programmer(laptop);
		
		p.coding();
	}
}
