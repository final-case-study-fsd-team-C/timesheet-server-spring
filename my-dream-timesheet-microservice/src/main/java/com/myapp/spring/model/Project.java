package com.myapp.spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data

public class Project {
	
	

	private int id;
	private String name;
	private Color projectColor;
	private String description;
	
	private int clientId;
	
	//@JsonManagedReference
	private Member members;
	
	private List<Phases> phases = new ArrayList<>();
	
	
}
