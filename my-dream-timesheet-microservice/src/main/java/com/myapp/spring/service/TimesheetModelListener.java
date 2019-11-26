package com.myapp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import com.myapp.spring.model.Project;
import com.myapp.spring.model.Timesheet;

@Component
public class TimesheetModelListener extends AbstractMongoEventListener<Timesheet> {

private CounterService counterService;

@Autowired
public TimesheetModelListener(CounterService counterService) {
this.counterService =counterService;
}



@Override
public void onBeforeConvert(BeforeConvertEvent<Timesheet> event) {
    if (event.getSource().getId() < 1) {
        event.getSource().setId(counterService.generateSequence(Timesheet.SEQUENCE_NAME));
    }
}
}
