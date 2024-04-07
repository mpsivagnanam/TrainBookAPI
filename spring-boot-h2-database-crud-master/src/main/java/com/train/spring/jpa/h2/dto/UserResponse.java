package com.train.spring.jpa.h2.dto;

/**
 * This class have user response
 */
public class UserResponse {

	/**
	 * Field to hold the email Id
	 */
	private String emailId;
	/**
	 * Field to hold the fist name
	 */
	private String firstName;
	/**
	 * Field to hold the last name
	 */
	private String lastName;
	/**
	 * @return
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
