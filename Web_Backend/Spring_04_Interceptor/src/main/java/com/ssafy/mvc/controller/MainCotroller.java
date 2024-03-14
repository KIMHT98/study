package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainCotroller {
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("password") String password) {

		// service만들어서 호출(원래대로면) -> 지금은 생략
		//아이디랑 비밀번호가 같으면 index페이지로 넘어감
		//로그인 성공했다는 의미
		if (id.equals("ssafy") && password.equals("1234")) {
			// 로그인 성공
			session.setAttribute("id", id);
			return "redirect:/";// 개인정보 안보이게 하기 // 슬래시 받으면 맨위에서 인덱스로 보내줌
		}
		//틀리면 계속 로그인페이지로 넘어옴
		return "redirect:/login";
	}

	@GetMapping("/logout")
	//로그아웃하면 index로 넘어옴
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/regist")
	public String goRegist() {
		return "regist";
	}

}
