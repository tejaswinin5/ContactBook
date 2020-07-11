package com.lwl.cbook.service.exception;

import lombok.Getter;

@Getter
public class ContactNotFoundException extends Exception {
	private static final long serialVersionUID = -1840651988520097302L;
	
	private String message;
	
	public ContactNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	public ContactNotFoundException() {
		super();
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContactAlreadyExistsException [message=").append(message).append("]");
		return builder.toString();
	}

}
