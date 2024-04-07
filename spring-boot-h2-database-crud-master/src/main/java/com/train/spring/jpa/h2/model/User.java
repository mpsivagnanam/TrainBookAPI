package com.train.spring.jpa.h2.model;

import jakarta.persistence.*;

/**
 * This is the user entity class
 */
@Entity
@Table(name = "user_details")
public class User {

  /**
   * 
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  /**
   * 
   */
  @Column(name = "first_name")
  private String firstName;

  /**
   * 
   */
  @Column(name = "last_name")
  private String lastName;

  /**
   * 
   */
  @Column(name = "email_id")
  private String emailId;

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
