package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="home", method = RequestMethod.GET)//그냥 "home"만 쓰면 get이든 post든 다 처리함
	public ModelAndView homeHandle1() {
		//데이터와 view 결과를 담은 바구니
		ModelAndView mav = new ModelAndView();	
		
		//데이터를 실어서 보내보자.
		//키와 밸류 형태로 넣는다.
		mav.addObject("msg","Welcome to Spring (GET)");
		
		//view 이름을 결정해야함 -> 포워딩 한 것과 같음
		mav.setViewName("home");
		return mav;
	}
	@RequestMapping(value="home", method = RequestMethod.POST)//그냥 "home"만 쓰면 get이든 post든 다 처리함
	public ModelAndView homeHandle2() {
		//데이터와 view 결과를 담은 바구니
		ModelAndView mav = new ModelAndView();	
		
		//데이터를 실어서 보내보자.
		//키와 밸류 형태로 넣는다.
		mav.addObject("msg","Welcome to Spring (POST)");
		
		//view 이름을 결정해야함 -> 포워딩 한 것과 같음
		mav.setViewName("home");
		return mav;
	}
}
