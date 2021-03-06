package com.myapp.spring.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Project;
import com.myapp.spring.repository.ProjectRepository;
import com.myapp.spring.service.CounterService;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProjectAPI {

	@Autowired
	private ProjectRepository repository;

	@Autowired
	private CounterService counterService;
	
	
	@GetMapping("/projects")
	public ResponseEntity<List<Project>> findAll(){
		
		List<Project> sheets=repository.findAll();		
		return new ResponseEntity<List<Project>>(sheets, HttpStatus.OK);
	}
	
	@GetMapping("/projects/{id}")
	public ResponseEntity<Project> findById(@PathVariable("id") int id)
	{ 
		return new ResponseEntity<Project>(repository.findById(id).get(), HttpStatus.GONE);
	}
	
	@PostMapping("/projects")
	public ResponseEntity<Project> addProject(@RequestBody Project project)
	{		
		project.setId(counterService.generateSequence(Project.SEQUENCE_NAME));
		project=repository.save(project);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	
	@PutMapping("/projects/{id}")
	public ResponseEntity<Project> updateExistingProject(
			@PathVariable("id")Integer id,@RequestBody Project project)
	{
		Project existingTimesheet = repository.findById(id).get();
		BeanUtils.copyProperties(project, existingTimesheet);
		
		existingTimesheet = repository.save(existingTimesheet);
		return new ResponseEntity<Project>(existingTimesheet, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/projects/{id}")
	public ResponseEntity<Project> delete(@PathVariable("id") int id)
	{ 
		repository.deleteById(id);
		Project phases = new Project();
		phases.setId(id);
		return new ResponseEntity<Project>(phases, HttpStatus.GONE);
	}
	
	
	
}
