package com.ssafy.user.service;

import java.util.List;

import com.ssafy.user.domain.User;

public interface UserService {

	List<User> findAll();
	int idCheck(String usesrId);
	User findByUserId(String userId);
	User login(String userId, String password);
	List<User> findByEmailLike(String email);
	List<User> findByEmailContaining(String email);
	
	User register(User user);
	
}
