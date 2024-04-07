package com.train.spring.jpa.h2.model;

import jakarta.persistence.*;

/**
 * This is the travel entity class
 */
@Entity
@Table(name = "travel_details")
public class Travel {

  /**
   * 
   */
	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * 
   */
  @Column(name = "departure")
  private String departure;

  /**
   * 
   */
  @Column(name = "arrival")
  private String arrival;

  /**
   * 
   */
  @Column(name = "price")
  private Float price;

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
	public String getDeparture() {
		return departure;
	}
	
	/**
	 * @param departure
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	
	/**
	 * @return
	 */
	public String getArrival() {
		return arrival;
	}
	
	/**
	 * @param arrival
	 */
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	
	/**
	 * @return
	 */
	public Float getPrice() {
		return price;
	}
	
	/**
	 * @param price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	
}
