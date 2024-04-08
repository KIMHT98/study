package com.ssafy.di2_객체의존성제거;

public class Programmer {
	private Laptop laptop;
	
	//객체 의존성 제거
	public Programmer(Laptop laptop) {
		//직접 생성하는 것이 아닌, 데스크톱을 인자로 받아서 제공
		this.laptop = laptop;
	}
	
	public void coding() {
		System.out.println(laptop.getInfo()+"으로 개발을 합니다.");
	}
}
