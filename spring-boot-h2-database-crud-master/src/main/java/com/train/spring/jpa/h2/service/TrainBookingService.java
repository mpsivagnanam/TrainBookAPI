package com.train.spring.jpa.h2.service;

import com.train.spring.jpa.h2.dto.Response;
import com.train.spring.jpa.h2.dto.TravelRequest;
import com.train.spring.jpa.h2.dto.TravelUpdateRequest;

public interface TrainBookingService {
	
	Response purchaseTicket(TravelRequest travelRequest);
	
	Response recepitTicket(String emailId);
	
	Response seatDetails(String emailId);
	
	Response removeTicket(String emailId);
	
	Response updateTicket(TravelUpdateRequest travelUpdateRequest);

}
