package com.train.spring.jpa.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.train.spring.jpa.h2.dto.Response;
import com.train.spring.jpa.h2.dto.TravelRequest;
import com.train.spring.jpa.h2.dto.TravelUpdateRequest;
import com.train.spring.jpa.h2.service.TrainBookingService;

/**
 * This class will be used for train booking api
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ticket")
public class TrainBookingController {

  @Autowired
  TrainBookingService trainBookingService;
  
  /**
   * This api used for purchasing a ticket 
   * @param travelRequest
   * @return
   */
  @PostMapping("/purchase")
  public ResponseEntity<Response> purchaseTicket(@RequestBody TravelRequest travelRequest) {
	  Response receiptResponse = trainBookingService.purchaseTicket(travelRequest);
	  return new ResponseEntity<Response>(receiptResponse, HttpStatus.OK);
  
  }
  
  /**
   * This api used to get the receipt by passing email Id
   * @param emailId
   * @return
   */
  @GetMapping("/receipt/{emailId}")
  public ResponseEntity<Response> receiptTicket(@PathVariable String emailId) {
	  Response receiptResponse = trainBookingService.recepitTicket(emailId);
	  return new ResponseEntity<Response>(receiptResponse, HttpStatus.OK);
  
  }
  
  /**
   * This api used to get seat details
   * @param emailId
   * @return
   */
  @GetMapping("/seat/{emailId}")
  public ResponseEntity<Response> seatDetails(@PathVariable String emailId) {
	  Response seatResponse = trainBookingService.seatDetails(emailId);
	  return new ResponseEntity<Response>(seatResponse, HttpStatus.OK);
  
  }
  

  /**
   * This method used for removing the user ticket details
   * @param emailId
   * @return
   */
  @DeleteMapping("/remove/{emailId}")
  public ResponseEntity<Response> removeUser(@PathVariable String emailId) {
	  Response seatResponse = trainBookingService.removeTicket(emailId);
	  return new ResponseEntity<Response>(seatResponse, HttpStatus.OK);
  
  }
  

  /**
   * This method used to update the seat deatails
   * @param travelUpdateRequest
   * @return
   */
  @PutMapping("/modify")
  public ResponseEntity<Response> updateSeat(@RequestBody TravelUpdateRequest travelUpdateRequest) {
	  Response seatResponse = trainBookingService.updateTicket(travelUpdateRequest);
	  return new ResponseEntity<Response>(seatResponse, HttpStatus.OK);
  
  }
}
