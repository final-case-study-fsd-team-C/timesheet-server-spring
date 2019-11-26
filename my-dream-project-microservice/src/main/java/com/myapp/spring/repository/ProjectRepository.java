package com.myapp.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Project;

@Repository
public interface ProjectRepository extends MongoRepository<Project, Integer> {

}
