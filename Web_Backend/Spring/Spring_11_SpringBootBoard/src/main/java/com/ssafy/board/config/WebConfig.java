package com.ssafy.board.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ssafy.board.interceptor.AdminPageInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	
	//뷰리졸버 설정
	@Value("${spring.mvc.view.prefix}")
	private String prefix;
	@Value("${spring.mvc.view.suffix}")
	private String suffix;
	
	@Bean
	public ViewResolver InternalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		//가져오지않고 직접 작성 가능
		resolver.setPrefix(prefix);
		resolver.setSuffix(suffix);
		resolver.setViewClass(JstlView.class);//없어도 동작하긴 함
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}
	
	//인터셉터 설정
	@Autowired
	AdminPageInterceptor adminPageInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminPageInterceptor).addPathPatterns("/users");
	}
}
