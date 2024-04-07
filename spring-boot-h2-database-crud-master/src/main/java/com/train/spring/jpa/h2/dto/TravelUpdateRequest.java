package com.train.spring.jpa.h2.dto;

/**
 * This is the update travel request
 */
public class TravelUpdateRequest {
	
	/**
	 * Field to hold the email Id
	 */
	private String emailId;
	/**
	 * Field to hold the section
	 */
	private String section;
	/**
	 * Field to hold the seat
	 */
	private Integer seat;
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
	public String getSection() {
		return section;
	}
	/**
	 * @param section
	 */
	public void setSection(String section) {
		this.section = section;
	}
	/**
	 * @return
	 */
	public Integer getSeat() {
		return seat;
	}
	/**
	 * @param seat
	 */
	public void setSeat(Integer seat) {
		this.seat = seat;
	}
	
	

}
