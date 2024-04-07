package com.train.spring.jpa.h2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * This is the seat entity class
 */
@Entity
@Table(name = "seat_details")
public class Seat {

  /**
   * 
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * 
   */
  @Column(name = "section")
  private String section;

  /**
   * 
   */
  @Column(name = "seat")
  private Integer seat;

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
