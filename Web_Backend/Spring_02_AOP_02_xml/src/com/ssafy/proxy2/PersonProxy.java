package com.ssafy.proxy2;

import java.util.Random;

public class PersonProxy implements Person {
	
	private Person person;
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
			System.out.println("컴퓨터 부팅");//이전에 수행해야할 친구
			try {
				person.coding();//핵심 관심 사항
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


