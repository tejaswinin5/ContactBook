package com.lwl.cbook.service.exception;

import lombok.Getter;

@Getter
public class ContactAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = -699448769244115155L;
	private String message;
	
	public ContactAlreadyExistsException() {
		this.message = "Contact already exists with given number";
	}
	
	public ContactAlreadyExistsException(String message) {
		super();
		this.message=message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactAlreadyExistsException [message=").append(message).append("]");
		return builder.toString();
	}
	
	
}
