package com.boot.learn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boot.learn.entity.User;
import com.boot.learn.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerUser(User reqUser) throws Exception {
		User foundUser = null;
		try {
			foundUser = this.findUserById(reqUser.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// If user found throw exception
		if(!ObjectUtils.isEmpty(foundUser)) {
			throw new Exception("User already exist");
		}
		else {
			foundUser = this.saveUser(reqUser);
		}

		return foundUser;
	}

	@Override
	public User saveUser(User reqUser) {
		User savedUser = this.userRepo.save(reqUser);
		return savedUser;
	}

	@Override
	public User findUserById(String userId) throws Exception {
		User foundUser = this.userRepo.findById(userId).orElseThrow(() -> new Exception("User not found"));
		return foundUser;
	}

}
