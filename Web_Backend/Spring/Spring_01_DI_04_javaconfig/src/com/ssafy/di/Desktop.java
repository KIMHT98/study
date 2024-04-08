package com.ssafy.di;

import org.springframework.stereotype.Component;

public class Desktop implements Computer {
	//필드명 작성
	//CPU,GPU,RAM, ... 등
	public Desktop() {
		System.out.println("데스크탑생성");
	}
	//정보를 반환
	public String getInfo() {
		return "데스크톱";
	}

}
