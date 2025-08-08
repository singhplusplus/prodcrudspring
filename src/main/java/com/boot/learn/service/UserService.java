package com.boot.learn.service;

import com.boot.learn.entity.User;

public interface UserService {

	public User registerUser(User reqUser) throws Exception;
	public User saveUser(User reqUser);
	public User findUserById(String userId) throws Exception;
	
}
