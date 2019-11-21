package com.myapp.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Timesheet;

@Repository
public interface TimesheetRepository extends MongoRepository<Timesheet, Integer> {

}
