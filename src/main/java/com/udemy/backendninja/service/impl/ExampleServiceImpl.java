package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Actor1", 25));
		people.add(new Person("Actriz1", 47));
		people.add(new Person("Actriz2", 60));
		people.add(new Person("Actor2", 92));
		people.add(new Person("prueba", 7));
		
		LOG.info("HELLO FROM SERVICE");
		
		return people;
	}

}
