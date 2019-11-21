package com.myapp.spring.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Clients;



@Repository
public interface ClientsRepository extends  MongoRepository<Clients, Integer> {
	
}