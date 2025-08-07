/**
 * 
 */
package com.boot.learn.exception;

/**
 * 
 */
public class UserAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public UserAlreadyExistException(String message) {
		super(message);
	}

}
