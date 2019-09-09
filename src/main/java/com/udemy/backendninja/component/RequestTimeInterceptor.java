package com.udemy.backendninja.component;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.udemy.backendninja.repository.LogRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestTimeInterceptor.
 */
@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter{
	
	/** The log repository. */
	@Autowired
	@Qualifier("logRepository")
	private LogRepository logRepository;
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(RequestTimeInterceptor.class);

	/**
	 * Pre handle.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	// PRIMERO: se ejecuta antes de ejecutar la peticion
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// esot guarda tiempo actual en milisec antes de ejecutar peticion
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	/**
	 * After completion.
	 *
	 * @param request the request
	 * @param response the response
	 * @param handler the handler
	 * @param ex the ex
	 * @throws Exception the exception
	 */
	// SEGUNDO: se ejectuta antes de retornanr la vista
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		long startTime = (long) request.getAttribute("startTime");
		String url = request.getRequestURL().toString();
		String username = "";
		
		Authentication auths = SecurityContextHolder.getContext().getAuthentication();
		if(null != auths && auths.isAuthenticated()) {
			username = auths.getName();
		}
		
		com.udemy.backendninja.entity.Log log = new com.udemy.backendninja.entity.Log(new Date(), auths.getDetails().toString(), username, url);
		logRepository.save(log);
		
		LOG.info("URL to: '" + url + "' in: '" + (System.currentTimeMillis() - startTime) + "'ms");
	}
	

}
