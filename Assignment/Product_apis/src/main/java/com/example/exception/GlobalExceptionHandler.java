package com.example.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	  @ExceptionHandler(ProductException.class) public
	 ResponseEntity<MyErrorDetails> CustomerExceptionHandler(ProductException pe,
	  WebRequest req) { MyErrorDetails err = new
	  MyErrorDetails(LocalDateTime.now(), pe.getMessage(),
	  req.getDescription(false));
	  
	  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST); 
	  
	  }
	  
	  @ExceptionHandler(salesOrderException.class) public
		 ResponseEntity<MyErrorDetails> salesOrderExceptionHandler(salesOrderException pe,
		  WebRequest req) { MyErrorDetails err = new
		  MyErrorDetails(LocalDateTime.now(), pe.getMessage(),
		  req.getDescription(false));
		  
		  return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST); }
	 
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyErrorDetails> illigalArgumetHandler(IllegalArgumentException ee, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(), ee.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> methodArgumetHandler(MethodArgumentNotValidException me, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(),
				me.getBindingResult().getFieldError().getDefaultMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> notfoundHandler(NoHandlerFoundException nof, WebRequest req)
	{
		MyErrorDetails err1 = new MyErrorDetails(LocalDateTime.now(), nof.getMessage(), req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err1, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(Exception ie, WebRequest req)
	{
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setName(ie.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	

}
