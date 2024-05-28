package com.ssafy.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.user.domain.User;
import com.ssafy.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public int idCheck(String usesrId) {
		return userRepository.countByUserId(usesrId);
	}

	@Override
	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
	
	@Override
	public User login(String userId, String password) {
		return userRepository.findByUserIdAndPassword(userId, password);
	}

	@Override
	public List<User> findByEmailLike(String email) {
		return userRepository.findByEmailLike(email);
	}

	@Override
	public List<User> findByEmailContaining(String email) {
		return userRepository.findByEmailContaining(email);
	}

	@Override
	@Transactional
	public User register(User user) {
		return userRepository.save(user);
	}

}
