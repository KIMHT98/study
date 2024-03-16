package com.ssafy.di4_의존성주입;

public class Test {
	public static void main(String[] args) {
		//의존관계역전 맛보기
		
		//스프링 컨테이너가 이런것을 해줌
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();
		Programmer p1 = new Programmer(desktop);
		p1.coding();
		
		Programmer p2 = new Programmer();
		p2.setComputer(laptop);
		p2.coding();
	}
}
