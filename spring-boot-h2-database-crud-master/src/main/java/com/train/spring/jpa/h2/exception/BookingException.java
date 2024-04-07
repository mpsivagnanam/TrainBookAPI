package com.train.spring.jpa.h2.exception;

/**
 * This class used to throw the exception
 */
public class BookingException extends RuntimeException{
	
	private String errorMessage;

	/**
	 * 
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * 
	 * @param errorMessage
	 */
	public BookingException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
