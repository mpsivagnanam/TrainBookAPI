package com.train.spring.jpa.h2.utils;

import com.train.spring.jpa.h2.dto.ReceiptResponse;
import com.train.spring.jpa.h2.dto.SeatResponse;
import com.train.spring.jpa.h2.dto.UserResponse;
import com.train.spring.jpa.h2.model.Seat;
import com.train.spring.jpa.h2.model.Travel;
import com.train.spring.jpa.h2.model.User;

/**
 * This is the utility class in the application
 */
public class ResponseUtils {


	/**
	 * This method will construct the receipt response
	 * @param user
	 * @param travel
	 * @return
	 */
	public static ReceiptResponse constructReceiptResponse(User user, Travel travel) {
		ReceiptResponse receiptResponse = new ReceiptResponse();
		  receiptResponse.setFrom(travel.getDeparture());
		  receiptResponse.setTo(travel.getArrival());
		  receiptResponse.setPricePaid(travel.getPrice());
		  
		  UserResponse userResponse =new UserResponse();
		  userResponse.setEmailId(user.getEmailId());
		  userResponse.setFirstName(user.getFirstName());
		  userResponse.setLastName(user.getLastName());
		  
		  receiptResponse.setUser(userResponse);
		return receiptResponse;
	}

	/**
	 * This method will construct the seat response
	 * @param user
	 * @param seat
	 * @return
	 */
	public static SeatResponse constructSeatResponse(User user, Seat seat) {
		SeatResponse seatResponse = new SeatResponse();
		seatResponse.setSeat(seat.getSeat());
		seatResponse.setSection(seat.getSection());
		  
		  UserResponse userResponse =new UserResponse();
		  userResponse.setEmailId(user.getEmailId());
		  userResponse.setFirstName(user.getFirstName());
		  userResponse.setLastName(user.getLastName());
		  
		  seatResponse.setUser(userResponse);
		return seatResponse;
	}

}
