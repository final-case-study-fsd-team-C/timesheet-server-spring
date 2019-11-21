package com.myapp.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Phases;



@Repository
public interface PhasesRepository extends  MongoRepository<Phases, Integer> {
	
}
