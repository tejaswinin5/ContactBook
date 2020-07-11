package com.lwl.cbook.domain;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {

	@Id
	private String id;
	private String name;
	private String email;
	private String mobile;
	//private LocalDate dob;
	private Address address;
}
