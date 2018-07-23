package com.example.demoexception.exception;

/**
 * @author C037695
 *Exception lanzada cuando falla la validacion de la curp de un usuario
 */
public class UserCurpException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserCurpException(String message) {
		super(message);
	}

	public UserCurpException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
