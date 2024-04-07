package com.train.spring.jpa.h2.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This is the parent response class
 */
@JsonInclude(Include.NON_NULL)
public class Response {

	
	/**
	 * Field to hold the info
	 */
	private String info;
	/**
	 * Field to hold the error message
	 */
	private String errorMessage;
	/**
	 * Field to hold the response code
	 */
	private Integer responseCode;
	
	/**
	 * @return
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * @param info
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	/**
	 * @return
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @param errorMessage
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	/**
	 * @return
	 */
	public Integer getResponseCode() {
		return responseCode;
	}
	/**
	 * @param responseCode
	 */
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	/**
	 *
	 */
	@Override
	public String toString() {
		return "Response [info=" + info + ", errorMessage=" + errorMessage + ", responseCode=" + responseCode + "]";
	}
	
	
	
}
