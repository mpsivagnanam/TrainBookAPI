package com.train.spring.jpa.h2.dto;

/**
 * This is the seat response class
 */
public class SeatResponse extends Response {

	/**
	 * Field to hold the seat
	 */
	private Integer seat;
	/**
	 * Field to hold the section
	 */
	private String section;
	/**
	 * Field to hold the user
	 */
	private UserResponse user;
	
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
	public UserResponse getUser() {
		return user;
	}
	/**
	 * @param user
	 */
	public void setUser(UserResponse user) {
		this.user = user;
	}
	/**
	 *
	 */
	@Override
	public String toString() {
		return "SeatResponse [seat=" + seat + ", section=" + section + ", user=" + user + "]";
	}
	
	
	
}
