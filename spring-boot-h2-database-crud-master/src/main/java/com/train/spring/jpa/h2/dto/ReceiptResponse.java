package com.train.spring.jpa.h2.dto;

/**
 * 
 */
public class ReceiptResponse extends Response{

	
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
	private Float pricePaid;
	/**
	 * Field to hold the user
	 */
	private UserResponse user;
	
	/**
	 * 
	 * @return
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * 
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * 
	 * @return
	 */
	public String getTo() {
		return to;
	}
	/**
	 * 
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * 
	 * @return
	 */
	public Float getPricePaid() {
		return pricePaid;
	}
	/**
	 * 
	 * @param pricePaid
	 */
	public void setPricePaid(Float pricePaid) {
		this.pricePaid = pricePaid;
	}
	/**
	 * 
	 * @return
	 */
	public UserResponse getUser() {
		return user;
	}
	/**
	 * 
	 * @param user
	 */
	public void setUser(UserResponse user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ReceiptResponse [from=" + from + ", to=" + to + ", pricePaid=" + pricePaid + ", user=" + user + "]";
	}
	
}
