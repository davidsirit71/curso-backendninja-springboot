package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example1")
public class ExampleController2 {
	
	public static final String EXAMPLE_VIEW = "example"; 
	
	@Autowired							// indica a spring que inyectamos un componente en memoria
	@Qualifier("exampleComponent")		//indica a spring nombre del beam que esta en su memoria tal como esta en @Component
	private ExampleComponent exampleComponent;	//esto declara el componete para usarlo
	
	// Primera forma de retornar plantilla: usada cuando se insertan pocos datos
	
	@GetMapping("/exampleString") 
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;  
	}
	
	// Segunda forma de retornar plantilla: usada cuando se insertan muchos datos en las plantilla
	

	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people", getPeople());
		return mav;
	}
	
	private List<Person> getPeople(){
		List<Person> people = new ArrayList<>();
		people.add(new Person("Actor1", 25));
		people.add(new Person("Actriz1", 47));
		people.add(new Person("Actriz2", 60));
		people.add(new Person("Actor2", 92));
		people.add(new Person("prueba", 7));		
		return people;
	}
	
	

}
