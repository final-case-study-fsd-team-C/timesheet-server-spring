package com.myapp.spring.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.myapp.spring.model.Phases;
import com.myapp.spring.model.Project;
import com.myapp.spring.model.Timesheet;
import com.myapp.spring.repository.TimesheetRepository;

@RestController
public class TimesheetAPI {

	@Autowired
	private TimesheetRepository repository;
	
	
	@GetMapping("/timesheet")
	public ResponseEntity<List<Timesheet>> findAll(){
		
		List<Timesheet> sheets=repository.findAll();		
		return new ResponseEntity<List<Timesheet>>(sheets, HttpStatus.OK);
	}
	
	@GetMapping("/timesheet/{id}")
	public ResponseEntity<Timesheet> findById(@PathVariable("id") int id)
	{ 
		return new ResponseEntity<Timesheet>(repository.findById(id).get(), HttpStatus.GONE);
	}
	
	@PostMapping("/timesheet")
	public ResponseEntity<Timesheet> addTimesheet(@RequestBody Timesheet timesheet)
	{		
		timesheet=repository.save(timesheet);
		return new ResponseEntity<Timesheet>(timesheet, HttpStatus.CREATED);
	}
	
	@PutMapping("/timesheet/{id}")
	public ResponseEntity<Timesheet> updateExistingTimesheet(
			@PathVariable("id")Integer id,@RequestBody Timesheet timesheet)
	{
		Timesheet existingTimesheet = repository.findById(id).get();
		BeanUtils.copyProperties(timesheet, existingTimesheet);
		
		existingTimesheet = repository.save(existingTimesheet);
		return new ResponseEntity<Timesheet>(existingTimesheet, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/timesheet/{id}")
	public ResponseEntity<Timesheet> delete(@PathVariable("id") int id)
	{ 
		repository.deleteById(id);
		Timesheet phases = new Timesheet();
		phases.setId(id);
		return new ResponseEntity<Timesheet>(phases, HttpStatus.GONE);
	}
	
	
	
}
