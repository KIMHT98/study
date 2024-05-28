package com.ssafy.user.controller;

import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.user.domain.User;
import com.ssafy.user.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j
public class UserController {

	private final UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<?> idCheck(@PathVariable("userId") String userId) throws Exception {
		log.info("idCheck - 호출 : " + userId);
		int idCount = userService.idCheck(userId);
		log.info("idCheck - idCount : " + idCount);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return ResponseEntity.ok().headers(header).body(idCount);
	}

	@PostMapping
	public ResponseEntity<?> registUser(@RequestBody User user) {
		log.info("registUser User - {}", user);
		userService.register(user);
//			return ResponseEntity.ok().build();
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		log.info("loginUser User - {}", user);
		user = userService.login(user.getUserId(), user.getPassword());
		if(user != null) {
	//		TODO: Token 설정등 로그인 관련 작업.
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}

}
