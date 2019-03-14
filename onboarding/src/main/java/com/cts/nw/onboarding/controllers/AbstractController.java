/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author 656579
 *
 */
@Controller
public class AbstractController {

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "dateOfBirth", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "startDate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "nationwideIdCreatedDate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "fgOnBoardingDate", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(Date.class, "releaseDate", new CustomDateEditor(dateFormat, true));
	} 
	
}
