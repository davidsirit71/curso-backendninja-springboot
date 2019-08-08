package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.Autoevaluacion1Service;

@Controller
@RequestMapping("/ejercicio")
public class Autoevaluacion1Controller {
	
	private static final Log LOGGER = LogFactory.getLog(Autoevaluacion1Controller.class);
	
	//vistas de la autoevaluacion
	public static final String VIEW_UNO = "autoeval1";
	public static final String VIEW_DOS = "autoeval2";
	
	@Autowired
	@Qualifier("autoevaluacion1Service")
	private Autoevaluacion1Service autoevaluacion1Service;
	
	//metodo 1 retorna con un string forma 1
	@GetMapping("/vistauno")
	public RedirectView autoevalUno () {
		LOGGER.info("ENTRO EN VISTA UNO" + " "+ autoevaluacion1Service.getMessageLog());
		return new RedirectView ("/ejercicio/vistados");		
	}
	
	//metodo 2 retorna con un string forma 2
	@GetMapping("/vistados")
	public ModelAndView autoevalDos () {
		LOGGER.info("ENTRO EN VISTA DOS" + autoevaluacion1Service.getMessageLog());
		ModelAndView mav = new ModelAndView(VIEW_DOS);
		mav.addObject("mensaje", autoevaluacion1Service.getMessageLog());
		return mav;		
	}
	
	

}
