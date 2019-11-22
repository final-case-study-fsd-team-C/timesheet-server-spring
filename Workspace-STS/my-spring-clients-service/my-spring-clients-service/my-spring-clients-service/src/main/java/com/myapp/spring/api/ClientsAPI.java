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


import com.myapp.spring.model.Clients;
import com.myapp.spring.repository.ClientsRepository;



@RestController
public class ClientsAPI {
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	@GetMapping("/clients")
	public ResponseEntity<List<Clients>> findAll(){
		return new ResponseEntity<List<Clients>>(clientsRepository.findAll(), HttpStatus.OK);	
		
	}
	
	@GetMapping("/clients/{id}")
	public ResponseEntity<Clients> findById(@PathVariable("id") int id)
	{ 
		return new ResponseEntity<Clients>(clientsRepository.findById(id).get(), HttpStatus.GONE);
	}
	
	@PostMapping("/clients")
	public ResponseEntity<Clients> addNewClients(@RequestBody Clients clients)
	{
		clients = clientsRepository.save(clients);
	return new ResponseEntity<Clients> (clients, HttpStatus.CREATED);
	}
	
	@PutMapping("/clients/{name}")
	public ResponseEntity<Clients> updateExistingClients(
			@PathVariable("name")Integer id,@RequestBody Clients clients)
	{
		Clients existingClients=clientsRepository.findById(id).get();
		BeanUtils.copyProperties(clients, existingClients);
		
		existingClients = clientsRepository.save(existingClients);
		return new ResponseEntity<Clients>(existingClients, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/clients/{name}")
	public ResponseEntity<Clients> deleteByName(@PathVariable("name") String name)
	{ 
		clientsRepository.deleteByName(name);
		Clients clients = new Clients();
		clients.setName(name);
		return new ResponseEntity<Clients>(clients, HttpStatus.GONE);
	}
	
	
}
