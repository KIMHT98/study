package com.ssafy.di1_의존성개념;

public class Programmer {
	private Desktop computer;
	
	public Programmer() {
		//컴퓨터 제공
		this.computer = new Desktop();
	}
	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발을 합니다.");
	}
}
