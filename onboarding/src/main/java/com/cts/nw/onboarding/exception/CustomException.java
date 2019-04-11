/**
 * 
 */
package com.cts.nw.onboarding.exception;

/**
 * @author 656579
 *
 */
public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param e
	 */
	public CustomException (String message, Exception e){
		super(message,e);
	}
	
	/**
	 * @param message
	 * @param e
	 */
	public CustomException (String message){
		super(message);
	}

	public CustomException(Exception e) {
		super(e);
	}
}
