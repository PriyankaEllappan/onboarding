/**
 * 
 */
package com.cts.nw.onboarding.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * @author 656579
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(SQLException.class)
	public ModelAndView handleSQLException(HttpServletRequest request, Exception ex){
		ModelAndView modelView = getModelView("errors/errorPage");
		modelView.addObject("errMessage" , "SQL Exception: " + ex.getLocalizedMessage());
		return modelView;
	}
	
	public ModelAndView handleSQLException(SQLException e) {
		ModelAndView modelView = getModelView("errors/errorPage");
		modelView.addObject("errMessage" , "SQL Exception: " + e.getLocalizedMessage());
		return modelView;
		
	}
	
	public ModelAndView handleNamingException(NamingException e) {
		ModelAndView modelView = getModelView("errors/errorPage");
		modelView.addObject("errMessage" , "Naming Exception: " + e.getLocalizedMessage());
		return modelView;
		
	}

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(){
		ModelAndView modelView = getModelView("errors/errorPage");
		modelView.addObject("errMessage" , "IO Exception Occurred");
		return modelView;
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNotFoundException(HttpServletRequest req, NoHandlerFoundException ex) {
		ex.printStackTrace();
		ModelAndView model = getModelView("errors/handlerNotFound");
		return model;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView otherException(HttpServletRequest req, Exception ex) {
		ex.printStackTrace();
		ModelAndView modelView = getModelView("errors/errorPage");
		modelView.addObject("errMessage" , "Exception Occurred : " + ex.getLocalizedMessage());
		return modelView;
	}

	private ModelAndView getModelView(String viewName) {
		ModelAndView model = new ModelAndView();
		model.setViewName(viewName);
		return model;
	}

	
}