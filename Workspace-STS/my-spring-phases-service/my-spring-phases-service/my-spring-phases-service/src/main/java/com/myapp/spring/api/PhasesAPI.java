package com.myapp.spring.api;

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
import com.myapp.spring.repository.PhasesRepository;


@RestController
public class PhasesAPI {
	
	@Autowired
	private PhasesRepository phasesRepository;
	
	@GetMapping("/phases")
	public ResponseEntity<List<Phases>> findAll(){
		return new ResponseEntity<List<Phases>>(phasesRepository.findAll(), HttpStatus.OK);	
		
	}
	
	@GetMapping("/phases/{id}")
	public Phases getById(@PathVariable("id") int id)
	{ 
		return phasesRepository.findById(id).get();
	}
	
	@PostMapping("/phases")
	public ResponseEntity<Phases> addNewPhases(@RequestBody Phases phases)
	{
		phases = phasesRepository.save(phases);
		return new ResponseEntity<Phases>(phases, HttpStatus.CREATED);
	}
	
	@PutMapping("/phases/{id}")
	public ResponseEntity<Phases> updateExistingPhases(
			@PathVariable("id")Integer id,@RequestBody Phases phases)
	{
		Phases existingPhases=phasesRepository.findById(id).get();
		BeanUtils.copyProperties(phases, existingPhases);
		
		existingPhases = phasesRepository.save(existingPhases);
		return new ResponseEntity<Phases>(existingPhases, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/phases/{name}")
	public ResponseEntity<Phases> delete(@PathVariable("name") String name)
	{ 
		phasesRepository.deleteByName(name);
		Phases phases = new Phases();
		phases.setName(name);
		return new ResponseEntity<Phases>(phases, HttpStatus.GONE);
	}
	
}
	
	



