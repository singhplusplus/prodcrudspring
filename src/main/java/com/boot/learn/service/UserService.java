package com.boot.learn.service;

import com.boot.learn.entity.User;
import com.boot.learn.exception.UserAlreadyExistException;
import com.boot.learn.exception.UserNotFoundException;

public interface UserService {

	public User registerUser(User reqUser) throws UserAlreadyExistException;
	public User saveUser(User reqUser);
	public User findUserByEmail(String userId) throws UserNotFoundException;
	
}
