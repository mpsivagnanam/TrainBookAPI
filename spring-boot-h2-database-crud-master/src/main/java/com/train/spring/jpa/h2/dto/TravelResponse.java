package com.train.spring.jpa.h2.dto;

/**
 * This class have travel response
 */
public class TravelResponse {

	/**
	 * Field to hold the from
	 */
	private String from;
	/**
	 * Field to hold the to
	 */
	private String to;
	/**
	 * Field to hold the price
	 */
	private String pricePaid;
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
	public String getPricePaid() {
		return pricePaid;
	}
	/**
	 * @param pricePaid
	 */
	public void setPricePaid(String pricePaid) {
		this.pricePaid = pricePaid;
	}
	
	
	
}
