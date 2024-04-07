package com.train.spring.jpa.h2.dto;

/**
 * This class have travel request details
 */
public class TravelRequest {
	
	/**
	 * Field to hold the from
	 */
	private String from;
	/**
	 * Field to hold the to
	 */
	private String to;
	/**
	 * Field to hold the emailId
	 */
	private String emailId;
	
	/**
	 * @return
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}
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
	
	

}
