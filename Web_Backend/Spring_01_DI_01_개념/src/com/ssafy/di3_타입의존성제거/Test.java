package com.ssafy.di3_타입의존성제거;

public class Test {
	public static void main(String[] args) {
		//의존관계역전 맛보기
		
		//스프링 컨테이너가 이런것을 해줌
		Desktop desktop = new Desktop();
		Programmer p1 = new Programmer(desktop);
		
		p1.coding();
		Laptop laptop = new Laptop();
		Programmer p2 = new Programmer(laptop);
		p2.coding();
		
	}
}
