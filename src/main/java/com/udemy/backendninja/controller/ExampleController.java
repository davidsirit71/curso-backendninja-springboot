package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example"; // esto permite cambiar solo aca y no en cada metodo
	
	// Primera forma de retornar plantilla: usada cuando se insertan pocos datos
	
//	@RequestMapping(value="/exampleString", method=RequestMethod.GET) // anotacion vieja padre
	@GetMapping("/exampleString") // anotacion hijo de la anterior
	public String exampleString(Model model) {
//		model.addAttribute("name", "PepePepe"); // añadir datos simple
		model.addAttribute("person", new Person("pepapig", 15));
		return EXAMPLE_VIEW; // aca la vista sin el .html
	}
	
	// Segunda forma de retornar plantilla: usada cuando se insertan muchos datos en las plantilla
	
//	@RequestMapping(value="/exampleMVA", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
//		mav.addObject("name", "Jaimito");	
		mav.addObject("person", new Person("DoraExplorer", 55));
		//return new ModelAndView(EXAMPLE_VIEW); // va la vista sin .html
		return mav;
	}
	

}
