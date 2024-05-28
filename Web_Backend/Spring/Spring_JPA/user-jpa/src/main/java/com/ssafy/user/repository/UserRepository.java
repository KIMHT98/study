package com.ssafy.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.user.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	int countByUserId(String userId);
	User findByUserIdAndPassword(String userId, String password);
	User findByUserId(String userId);
	List<User> findByEmailLike(String email);
	List<User> findByEmailContaining(String email);
}
