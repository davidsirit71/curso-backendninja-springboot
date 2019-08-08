package com.udemy.backendninja.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.Autoevaluacion1Service;

@Service("autoevaluacion1Service")
public class Autoevaluacion1ServiceImpl implements Autoevaluacion1Service{
	
	private static final Log LOG = LogFactory.getLog(Autoevaluacion1ServiceImpl.class);

	@Override
	public String getMessageLog() {
		String mensaje = "cumplida la tarea";
		
		LOG.info("HELLO FROM SERVICE AUTOEVAL");
		
		return mensaje;
	}

}
