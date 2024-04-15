package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.User;
import com.ssafy.board.model.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	private final UserService uService;
	
	@Autowired
	public UserController(UserService uService) {
		this.uService = uService;
	}
	
	//로그인 페이지로 가자
	@GetMapping("/login")
	public String showLoginForm() {
		return "/user/loginform";
	}
	//로그인 하기
	@PostMapping("/login")
	public String doLogin(@ModelAttribute User user, HttpSession session) {
		User loginUser = uService.login(user.getId(), user.getPassword());
		if(loginUser == null)
			return "redirect:login";
		session.setAttribute("loginUser", loginUser.getName());
		return "redirect:list";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String doLogout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:list";
	}
	//유저등록
	@GetMapping("/signup")
	public String signupForm() {
		return "/user/signupform";
	}
	@PostMapping("/signup")
	public String dosignup(@ModelAttribute User user) {
		uService.signup(user);
		//성공적으로 회원가입 완료시
		//1.회원가입 축하 페이지로 이동
		//2.로그인 페이지로 이동
		//3.게시글 목록 화면으로 이동
		//3-1. 이 User객체를 그대로 실어서 로그인 요청 보내기
		//3-2. 세션 불러서 직접 등록해버리고 넘어간다.
		return "redirect:login";
	}
	@GetMapping("/users")
	public String userList(Model model) {
		model.addAttribute("userList",uService.getUserList());
		return "/user/adminPage";
	}
}
