package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/example4")
public class Example4Controller {
	
	public static final String FORM_VIEW = "/error/404";
	
	@GetMapping("/error")
	public ModelAndView exampleErrorReturn() {
		ModelAndView mav = new ModelAndView(FORM_VIEW);
		return mav;
	}
	
//	@GetMapping("/error")
//	public String exampleErrorReturn() {
////		ModelAndView mav = new ModelAndView(FORM_VIEW);
//		return "redirect:/static/imgs/2.png";
//	}

}
