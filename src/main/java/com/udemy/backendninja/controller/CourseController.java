package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//import com.udemy.backendninja.entity.Course; // ya no usa entidades
import com.udemy.backendninja.entity.CourseModel;
import com.udemy.backendninja.service.CourseService;


@Controller
@RequestMapping("/courses")
public class CourseController {
	
	private static final String COURSES_VIEW = "courses";
	
	private static final Log LOG = LogFactory.getLog(CourseController.class);
	
	@Autowired
	@Qualifier("courseServiceImpl")
	private CourseService courseService;
	
	@GetMapping("/listcourses")
	public ModelAndView listAllCourses() {
		LOG.info("Call: " + "listAllCourses()");
		ModelAndView mav = new ModelAndView(COURSES_VIEW);
		mav.addObject("course", new CourseModel());  // este objeto se crea para que thymeleaf pueda trabajar en el formulario
		mav.addObject("courses", courseService.listAllCourses());
		return mav;		
	}
	
	@PostMapping("/addcourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel) {
		LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
		courseService.addCourse(courseModel);
		return "redirect:/courses/listcourses";
	}

}
