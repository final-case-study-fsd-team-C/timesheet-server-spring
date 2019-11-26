package com.myapp.spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data

public class Project {
	
	
	@Transient
	public static final String SEQUENCE_NAME="projects_sequence";
	@Id
	private long id;
	private String name;
	private Color projectColor;
	private String description;
	
	private int clientId;
	
	private int seq;
	//@JsonManagedReference
	private Member members;
	
	private List<Phases> phases = new ArrayList<>();
	
	
}
