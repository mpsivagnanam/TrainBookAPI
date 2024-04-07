package com.bezkoder.spring.jpa.h2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.train.spring.jpa.h2.SpringBootJpaH2Application;
import com.train.spring.jpa.h2.dto.ReceiptResponse;
import com.train.spring.jpa.h2.dto.Response;
import com.train.spring.jpa.h2.dto.SeatResponse;
import com.train.spring.jpa.h2.dto.TravelRequest;
import com.train.spring.jpa.h2.utils.ResponseMessage;

@SpringBootTest(classes = SpringBootJpaH2Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class SpringBootJpaH2ApplicationTests {

		public static final String HOST = "http://localhost:";
	 	
	 	@LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;
	    
	    @Test
	    @Sql({"classpath:data.sql" })
	    @Order(1) 
	    void testPurchaseTicket() throws MalformedURLException {
	    	TravelRequest travelRequest = new TravelRequest();
	    	travelRequest.setEmailId("walterwhite@gmail.com");
	    	travelRequest.setFrom("London");
	    	travelRequest.setTo("France");
	    	
	    	ResponseEntity<ReceiptResponse> response = restTemplate.postForEntity(
	    			HOST + port + "/ticket/purchase",travelRequest, ReceiptResponse.class);
	        ReceiptResponse receiptResponse = new ReceiptResponse();
	        receiptResponse.setFrom("London");
	        receiptResponse.setTo("France");
	        receiptResponse.setPricePaid(Float.valueOf("5.0"));
	        receiptResponse.setUser(response.getBody().getUser());
	        assertTrue(new ReflectionEquals(receiptResponse).matches(response.getBody()));
	    	
	    }
	    
	    @Test
	    @Order(2) 
	    void testReceiptTicket() throws MalformedURLException, URISyntaxException {
	    	
	    	ResponseEntity<ReceiptResponse> response = restTemplate.getForEntity(new URI(
	    			HOST + port + "/ticket/receipt/walterwhite@gmail.com"), ReceiptResponse.class);
	    	ReceiptResponse receiptResponse = new ReceiptResponse();
	        receiptResponse.setFrom("London");
	        receiptResponse.setTo("France");
	        receiptResponse.setPricePaid(Float.valueOf("5.0"));
	        receiptResponse.setUser(response.getBody().getUser());
	        assertTrue(new ReflectionEquals(receiptResponse).matches(response.getBody()));
	    	
	    }
	    
	    @Test
	    @Order(3) 
	    void testSeatDetails() throws MalformedURLException, URISyntaxException {
	    	
	    	ResponseEntity<SeatResponse> response = restTemplate.getForEntity(new URI(
	    			HOST + port + "/ticket/seat/walterwhite@gmail.com"), SeatResponse.class);
	    	
	    	System.out.println("seat --- " +(SeatResponse)response.getBody());
	    	SeatResponse seatResponse = new SeatResponse();
	    	seatResponse.setSeat(4);
	    	seatResponse.setSection("B");
	    	seatResponse.setUser(response.getBody().getUser());
	    	
	        assertTrue(new ReflectionEquals(seatResponse).matches(response.getBody()));
	    	
	    }
	    
	    @Test
	    @Order(4) 
	    void testModifyTicket() throws MalformedURLException {
	    	
	    	HttpHeaders httpHeaders = new HttpHeaders();
	    	httpHeaders.add("Content-Type", "application/json");
	    	
	    	  HttpEntity<String> requestEntity = new HttpEntity<>("{\n"
	    	  		+ "    \"emailId\":\"walterwhite@gmail.com\",\n"
	    	  		+ "    \"section\":\"A\",\n"
	    	  		+ "    \"seat\":\"1\"\n"
	    	  		+ "}", httpHeaders);
	        ResponseEntity<Response> responseEntity = restTemplate.exchange(HOST + port + "/ticket/modify", HttpMethod.PUT, requestEntity, Response.class);
	    	Response responseUpdate = new Response();
	    	responseUpdate.setInfo(ResponseMessage.TICKET_UPDATED);
	        assertTrue(new ReflectionEquals(responseUpdate).matches(responseEntity.getBody()));
	    	
	    }
	    
	    @Test
	    @Order(5) 
	    void testRemoveTicket() throws MalformedURLException {
	    	
	        ResponseEntity<Response> responseEntity = restTemplate.exchange(HOST+ port + "/ticket/remove/walterwhite@gmail.com", HttpMethod.DELETE, null, Response.class);
	    	Response responseUpdate = new Response();
	    	responseUpdate.setInfo(ResponseMessage.TICKET_REMOVED);
	        assertTrue(new ReflectionEquals(responseUpdate).matches(responseEntity.getBody()));
	    	
	    }

}
