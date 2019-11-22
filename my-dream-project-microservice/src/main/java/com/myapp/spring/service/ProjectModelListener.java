package com.myapp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.myapp.spring.model.Project;

@Component
public class ProjectModelListener extends AbstractMongoEventListener<Project> {

private CounterService counterService;

@Autowired
public ProjectModelListener(CounterService counterService) {
this.counterService =counterService;
}

@Override
public void onBeforeConvert(BeforeConvertEvent<Project> event) {
if (event.getSource().getId() < 1) {
event.getSource().setId(counterService.getNextSequence(Project.SEQUENCE_NAME));
}
}
}
