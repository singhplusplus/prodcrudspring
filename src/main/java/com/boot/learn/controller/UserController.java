/**
 * 
 */
package com.boot.learn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.learn.entity.User;
import com.boot.learn.exception.UserAlreadyExistException;
import com.boot.learn.service.UserService;


/**
 * 
 */
@RestController @RequestMapping("auth")
public class UserController {

//	private final Logger _logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService authService;

	@GetMapping("test")
	public String testAuth() {
		return "Auth successful.";
	}

	@PostMapping("register")
	public User registerUser(@RequestBody User reqUser) throws UserAlreadyExistException {
		User registerUser = this.authService.registerUser(reqUser);
//		try {
//		} catch (Exception e) {
//			// e.printStackTrace();
//			this._logger.error(e.getMessage(), e);
//		}
		return registerUser;
	}

}
