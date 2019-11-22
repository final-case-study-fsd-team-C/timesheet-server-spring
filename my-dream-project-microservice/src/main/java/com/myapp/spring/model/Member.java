package com.myapp.spring.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Member implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String hourlyrate;

}
