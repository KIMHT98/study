package com.ssafy.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//내가 설정파일이다!
public class ApplicationConfig {
	
	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
	@Bean
	public Laptop laptop() {
		return new Laptop();
	}
	
	@Bean
	public Programmer programmer() {
		//생성자 주입이든 설정자 주입이든 문제 없다!
		Programmer p = new Programmer(desktop());
		return p;
		
	}
}
