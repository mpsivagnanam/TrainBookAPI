package com.train.spring.jpa.h2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.train.spring.jpa.h2.dto.Response;
import com.train.spring.jpa.h2.utils.ResponseMessage;


/**
 * This class used to process the exception response and send it to API
 * 
 */
@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {
   
	/**
	 * This method construct the error response
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(value = BookingException.class)
    public ResponseEntity<Response> handleHttpMessageNotReadable(BookingException ex, WebRequest request) {
        Response response = new Response();
        if(!ObjectUtils.isEmpty(ex.getMessage())) {
        	response.setErrorMessage(ex.getMessage());
        }else {
        	response.setErrorMessage(ResponseMessage.GENERIC_ERROR_MSG);
        }
        
        response.setResponseCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
    }

    
}
