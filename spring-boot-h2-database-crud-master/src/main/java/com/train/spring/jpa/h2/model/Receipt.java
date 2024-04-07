package com.train.spring.jpa.h2.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This is the Receipt entity class
 */
@Entity
@Table(name = "receipt_details")
public class Receipt {

  /**
   * 
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * 
   */
  @Column(name = "user_id")
  private long userId;

  /**
   * 
   */
  @Column(name = "seat_id")
  private long seatId;
  
  /**
   * 
   */
  @Column(name = "travel_id")
  private long travelId;

  /**
   * 
   */
  @Column(name = "booking_time")
  private Date bookingTime;

	/**
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public long getUserId() {
		return userId;
	}
	
	/**
	 * @param userId
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * @return
	 */
	public long getSeatId() {
		return seatId;
	}
	
	/**
	 * @param seatId
	 */
	public void setSeatId(long seatId) {
		this.seatId = seatId;
	}
	
	/**
	 * @return
	 */
	public long getTravelId() {
		return travelId;
	}
	
	/**
	 * @param travelId
	 */
	public void setTravelId(long travelId) {
		this.travelId = travelId;
	}
	
	/**
	 * @return
	 */
	public Date getBookingTime() {
		return bookingTime;
	}
	
	/**
	 * @param bookingTime
	 */
	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
  
}
