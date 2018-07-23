package com.example.demoexception.exception;

/**
 * @author C037695
 *Exception usada cuando no se encuentra usuario por id
 */
public class UserNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
