package com.example.BlogApplication.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFound extends RuntimeException{
	String resourseName;
	String fieldName;
	long fieldValue;
	public ResourceNotFound(String resourseName, String fieldName, long fieldValue) {
		super(String.format("%s not found with %s : %s",resourseName,fieldName,fieldValue));
		this.resourseName = resourseName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}
