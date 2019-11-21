package com.myapp.spring.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myapp.spring.model.Phases;

@FeignClient("PHASES-MS")
public interface PhasesClient {

	@PostMapping("/phases")
	ResponseEntity<Phases> addNewPhases(@RequestBody Phases phases);
	
	@GetMapping("/phases/{id}")
	Phases findById(@PathVariable("id")int id);
}
 