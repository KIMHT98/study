package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ControllerParameter {

	@GetMapping("/test1") // test1이라는 get요청이 다 여기로 옴
	public String test1() {//

		// 반환타입이 String이라는 뜻은 해당 값이 ViewName이다.
		// ViewResolver가 잡아다가 WEB_INF/view/test1.jsp로 바꿔서 실행
		return "test1";
	}

	// 데이터를 실어서 보내기 -> ModelAndView사용안하기
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		model.addAttribute("msg", "반가워");
		return "test2";
	}

	// 데이터를 실어서 보내기 -> ModelAndView사용안하기
	@GetMapping("/test2-2")
	public String test2_2(Map<String, Object> model) {
		model.put("msg", "반가워2");
		return "test2";
	}
	
	//파라미터로 값을 가져오고 싶다.
	@GetMapping("/test3-1")
	public String test3_1(Model model,HttpServletRequest request) {
		String id = request.getParameter("id");
		model.addAttribute("id",id);
		return "test3";
	}
	//파라미터로 값을 가져오고 싶다.
		@GetMapping("/test3-2")
		public String test3_2(Model model,@RequestParam("id") String id,@RequestParam(value="pw",defaultValue = "1234") String pw) {
			model.addAttribute("id",id);  
			model.addAttribute("pw",pw);
			
			return "test3";
		}
}
