package com.myapp.spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Document
@Data

public class Timesheet {
	

	@Transient
	public static final String SEQUENCE_NAME="timesheets_sequence";

	@Id
	private long id;

//@JsonManagedReference
	private Project project;



//@Transient
	private int timeWorked;
	private String phase;
	private String date;
	private String note;


}
