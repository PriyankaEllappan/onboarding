/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 656579
 *
 */
@Controller
public class AdminController extends AbstractController{

	Logger log = Logger.getLogger(AdminController.class);
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/admin/register", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelView;
		try {
			modelView = bindViewwithUserInfo("admin/registerUser");
		} catch (Exception e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e.getMessage());
		}
		return modelView;
	}
	
}
