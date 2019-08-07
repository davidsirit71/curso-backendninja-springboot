package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	//como rpimer paso se despliega el formulario
	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	//forma 1... esto nos redirije siempre al formulario
	/*@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showform";
		
	}*/
	
	//forma -- redireccion objeto redirect
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showform");
	}
	
	
	@GetMapping("/showform")
	public String showform(Model model) {	
		model.addAttribute("person", new Person());
		int i = 6/0;
		return FORM_VIEW;
		
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);	
		mav.addObject("person", person);
		return mav;
		
	}
	
}
