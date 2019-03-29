/**
 * 
 */
package com.cts.nw.onboarding.exception;

/**
 * @author 656579
 *
 */
public class ValidatorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidatorException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param e
	 */
	public ValidatorException(String message, Exception e){
		super(message,e);
	}
	
}
