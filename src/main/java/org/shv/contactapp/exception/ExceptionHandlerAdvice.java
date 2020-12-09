package org.shv.contactapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ControllerAdvice
public class ExceptionHandlerAdvice {
	  
	  @ResponseBody
	  @ExceptionHandler(ContactNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  public String contactNotFoundHandler(ContactNotFoundException ex) {
	    return ex.getMessage();
	  }
}

