package com.example.demoexception.exception;

/**
 * @author C037695
 *Exception que se lanza cuando falla la consulta al servicio de renapo
 */
public class RenapoServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RenapoServiceException(String message) {
		super(message);
	}

	public RenapoServiceException(String message, Throwable throwable) {
		super(message, throwable);
	}

}
