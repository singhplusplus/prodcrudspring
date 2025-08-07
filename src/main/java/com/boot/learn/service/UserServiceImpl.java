package com.boot.learn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.boot.learn.entity.User;
import com.boot.learn.exception.UserAlreadyExistException;
import com.boot.learn.exception.UserNotFoundException;
import com.boot.learn.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

//	private final Logger _logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepo;

	@Override
	public User registerUser(User reqUser) throws UserAlreadyExistException {
		User foundUser = this.userRepo.findByEmail(reqUser.getEmail()).orElse(null);

		// If user found throw exception
		if(!ObjectUtils.isEmpty(foundUser)) {
			// this._logger.error("User Already exist", reqUser);
			throw new UserAlreadyExistException("User already exist");
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
	public User findUserByEmail(String userId) throws UserNotFoundException {
		User foundUser = this.userRepo.findByEmail(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
		return foundUser;
	}

}
