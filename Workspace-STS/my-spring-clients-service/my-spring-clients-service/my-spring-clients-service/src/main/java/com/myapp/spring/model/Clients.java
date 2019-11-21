package com.myapp.spring.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Clients implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String name;
	private Color color;
	private int noOfProjects;
	/*
	 * @JsonManagedReference private Phases phases;
	 */
	
}
