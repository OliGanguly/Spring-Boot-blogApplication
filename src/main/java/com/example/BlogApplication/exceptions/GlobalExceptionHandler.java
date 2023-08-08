package com.example.BlogApplication.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.BlogApplication.repo.ApiResponse;

//@ControllerAdvice - 
/*
 * specialization of @component which allows to handle exception accross whole application
 * its handles all the the exception comes from @Requestmapping
 * */
//make this class foe exception handler , 
//if exception comes it will call the method from the class , it scans all controller classes

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> resourseNotFoundExceptionHandler(ResourceNotFound ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
    
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String,String>> HandleMethodArgumentNotValidException
(MethodArgumentNotValidException ex) {
	/*
	 * say 4 fields are Invalid ,fetch four field , with message
	 * 
	 * */
	//Blank map - will contaion all result
	Map<String,String> errors= new HashMap<>();
	//get error one by one
	//ex.getBindingResult().getAllErrors()-get a list of errors
	ex.getBindingResult().getAllErrors().forEach(error->{
		String FieldError = ((FieldError)error).getField();
		String message = error.getDefaultMessage();
		errors.put(FieldError, message);
	});
	
	return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
}
}
	


/*@ControllerAdvice
 * public class GlobalException{
 * @ExceptionHandler(Exception.class)
 * public ModelAndView exceptionHandler(Exception exception){
 *  ModelAndView errorpage = new ModelAndVie();
 *  errorpage.setViewName("error");
 *  errorpage.addObject("errormsg",exception.getMessage());
 *  return errorpage;
 * }
 * }
 * */
