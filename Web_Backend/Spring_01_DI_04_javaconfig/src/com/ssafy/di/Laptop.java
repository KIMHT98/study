package com.ssafy.di;

import org.springframework.stereotype.Component;

public class Laptop implements Computer  {
	//필드명 작성
	//CPU,GPU,RAM, ... 등
	
	//정보를 반환
	public String getInfo() {
		return "랩탑";
	}

}
