/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 656579
 *
 */
@Controller
public class RequesterController {

	/**
	 * Index Method redirects to Resources List Page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check", method = RequestMethod.GET)
	public String index(Model model) {
		System.out.println("In");
		return "request/checkResourceAvailability";
	}
	
}
