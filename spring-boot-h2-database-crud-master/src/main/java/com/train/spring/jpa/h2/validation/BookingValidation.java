package com.train.spring.jpa.h2.validation;

import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.train.spring.jpa.h2.exception.BookingException;
import com.train.spring.jpa.h2.utils.ResponseMessage;

public class BookingValidation {
	
	 public static void mandatoryDataValidation(String emailId) throws RuntimeException{
		if(ObjectUtils.isEmpty(emailId)) {
			throw new BookingException(ResponseMessage.EMAIL_NOT_EMPTY);
		}
	}
	
	 public static void userListValidation(List objectList) throws RuntimeException{
			if(CollectionUtils.isEmpty(objectList)) {
				throw new BookingException(ResponseMessage.USER_NOT_AVAILABLE);
			}
		}
	 
	 public static void receiptListValidation(List objectList) throws RuntimeException{
			if(CollectionUtils.isEmpty(objectList)) {
				throw new BookingException(ResponseMessage.RECEIPT_NOT_AVAILABLE);
			}
		}
	 
	 public static void travelObjectValidation(Object objectList) throws RuntimeException{
			if(ObjectUtils.isEmpty(objectList)) {
				throw new BookingException(ResponseMessage.Travel_NOT_AVAILABLE);
			}
		}
	 
	 public static void travelListValidation(List objectList) throws RuntimeException{
			if(CollectionUtils.isEmpty(objectList)) {
				throw new BookingException(ResponseMessage.Travel_NOT_AVAILABLE);
			}
		}
	 
	 public static void seatListValidation(List objectList) throws RuntimeException{
			if(CollectionUtils.isEmpty(objectList)) {
				throw new BookingException(ResponseMessage.SEAT_NOT_AVAILABLE);
			}
		}

	 public static void seatObjectValidation(Object objectList) throws RuntimeException{
			if(ObjectUtils.isEmpty(objectList)) {
				throw new BookingException(ResponseMessage.SEAT_NOT_AVAILABLE);
			}
		}
	 
	


}
