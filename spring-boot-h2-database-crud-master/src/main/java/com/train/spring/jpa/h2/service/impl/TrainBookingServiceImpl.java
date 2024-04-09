package com.train.spring.jpa.h2.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.train.spring.jpa.h2.dto.ReceiptResponse;
import com.train.spring.jpa.h2.dto.Response;
import com.train.spring.jpa.h2.dto.SeatResponse;
import com.train.spring.jpa.h2.dto.TravelRequest;
import com.train.spring.jpa.h2.dto.TravelUpdateRequest;
import com.train.spring.jpa.h2.exception.BookingException;
import com.train.spring.jpa.h2.model.Receipt;
import com.train.spring.jpa.h2.model.Seat;
import com.train.spring.jpa.h2.model.Travel;
import com.train.spring.jpa.h2.model.User;
import com.train.spring.jpa.h2.repository.ReceiptRepository;
import com.train.spring.jpa.h2.repository.SeatRepository;
import com.train.spring.jpa.h2.repository.TravelRepository;
import com.train.spring.jpa.h2.repository.UserRepository;
import com.train.spring.jpa.h2.service.TrainBookingService;
import com.train.spring.jpa.h2.utils.ResponseMessage;
import com.train.spring.jpa.h2.utils.ResponseUtils;
import com.train.spring.jpa.h2.validation.BookingValidation;

/**
 * This class will process the train booking request and send the response
 * 
 */
@Service
public class TrainBookingServiceImpl implements TrainBookingService{

	 @Autowired
	 UserRepository userRepository;
	  
	 @Autowired
	 TravelRepository travelRepository;
	  
	 @Autowired
	 ReceiptRepository receiptRepository;
	 
	 @Autowired
	 SeatRepository seatRepository;
	
	 /**
	  * 
	  * @param travelRequest
	  * @return receiptResponse
	  */
	@Override
	public ReceiptResponse purchaseTicket(TravelRequest travelRequest) throws BookingException{

	  List<User> userList = userRepository.findByEmailId(travelRequest.getEmailId());
	  BookingValidation.userListValidation(userList);
	  final Receipt receipt = new Receipt();
	  receipt.setBookingTime(new Date());
	  
	  seatSelectionProcess(receipt);
	  
	  if(ObjectUtils.isEmpty(receipt.getId())) {
		  ReceiptResponse receiptResponse = new ReceiptResponse();
		  receiptResponse.setInfo(ResponseMessage.SEAT_FULL);
		  return receiptResponse;
	  }
	  
	  receipt.setUserId(userList.get(0).getId());
	  List<Travel> travelList = travelRepository.findByDepartureAndArrival(travelRequest.getFrom(), travelRequest.getTo());
	  BookingValidation.travelListValidation(travelList);
	  
	  receipt.setTravelId(travelList.get(0).getId());
	  receiptRepository.save(receipt);
	  
	  ReceiptResponse receiptResponse = ResponseUtils.constructReceiptResponse(userList.get(0), travelList.get(0));
	  return receiptResponse;
	  
	}


	/**
	 * 
	 * @param emailId
	 * @return receiptResponse
	 */
	@Override
	public ReceiptResponse recepitTicket(String emailId) throws BookingException {
	
	BookingValidation.mandatoryDataValidation(emailId);
	
	List<User> userList =	userRepository.findByEmailId(emailId);
	BookingValidation.userListValidation(userList);
	
	List<Receipt> receiptList  = receiptRepository.findByUserId(userList.get(0).getId());
	BookingValidation.receiptListValidation(receiptList);
	
	Optional<Travel> travel = travelRepository.findById(receiptList.get(0).getTravelId());
	BookingValidation.travelObjectValidation(travel);
	
	ReceiptResponse receiptResponse = ResponseUtils.constructReceiptResponse(userList.get(0), travel.get());
	return receiptResponse;
	}
	
	/**
	 * @param emailId
	 * @return seatResponse
	 */
	@Override
	public SeatResponse seatDetails(String emailId) {
		
		List<User> userList =	userRepository.findByEmailId(emailId);
		BookingValidation.userListValidation(userList);

		List<Receipt> receiptList  = receiptRepository.findByUserId(userList.get(0).getId());
		BookingValidation.receiptListValidation(receiptList);
		
		Optional<Seat> train = seatRepository.findById(receiptList.get(0).getSeatId());
		BookingValidation.seatObjectValidation(train);
		
		SeatResponse seatResponse = ResponseUtils.constructSeatResponse(userList.get(0), train.get());
		
		return seatResponse;
	}
	
	/**
	 * 
	 * @param emailId
	 * @return response
	 */
	@Override
	public Response removeTicket(String emailId) throws BookingException{
		
		List<User> userList =	userRepository.findByEmailId(emailId);
		BookingValidation.userListValidation(userList);
		
		List<Receipt> receiptList  = receiptRepository.findByUserId(userList.get(0).getId());
		BookingValidation.receiptListValidation(receiptList);
		
		receiptRepository.delete(receiptList.get(0));
		
		Response response = new Response();
		response.setInfo(ResponseMessage.TICKET_REMOVED);
		return response;
		
	}
	/**
	 * 
	 * @param travelUpdateRequest
	 * @return response
	 */
	@Override
	public Response updateTicket(TravelUpdateRequest travelUpdateRequest) {

		List<User> userList =	userRepository.findByEmailId(travelUpdateRequest.getEmailId());
		BookingValidation.userListValidation(userList);
		
		List<Receipt> receiptList  = receiptRepository.findByUserId(userList.get(0).getId());
		BookingValidation.receiptListValidation(receiptList);
		
		Receipt receipt	= receiptList.get(0);
		
		List<Seat> trainList = seatRepository.findBySectionAndSeat(travelUpdateRequest.getSection(), travelUpdateRequest.getSeat());
		List<Receipt> checkReceiptList  = receiptRepository.findBySeatId(trainList.get(0).getId());
		  if(CollectionUtils.isEmpty(checkReceiptList)) {
			  receipt.setSeatId(trainList.get(0).getId());
		  }else {
				  ReceiptResponse receiptResponse = new ReceiptResponse();
				  receiptResponse.setInfo(ResponseMessage.SEAT_FULL);
				  return receiptResponse;
			  
		  }
		receiptRepository.save(receipt);
		
		Response response = new Response();
		response.setInfo(ResponseMessage.TICKET_UPDATED);
		return response;
	}
	
	/**
	 * This method will find the empty seat and get the id and fill it in receipt model
	 * @param receipt
	 */
	private void seatSelectionProcess(final Receipt receipt) {
		List<Seat> trainList = seatRepository.findAll();
		  
		trainList.forEach( e -> {
			  List<Receipt> receiptList  = receiptRepository.findBySeatId(e.getId());
			  if(CollectionUtils.isEmpty(receiptList)) {
				  receipt.setSeatId(e.getId());
			  }
			  
		  });
	}
	
	
	


}
