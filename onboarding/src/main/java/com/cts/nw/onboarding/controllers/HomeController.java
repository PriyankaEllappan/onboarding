
package com.cts.nw.onboarding.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.util.UserDetails;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/")
public class HomeController extends AbstractController {

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "commons/login";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "commons/login";
	}
	
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = null;
		try {
			model = new ModelAndView("commons/accessDenied");
			if (user != null) {
				model.addObject("msg", "Hi " + user.getName() + ", You do not have access rights to view this page!");
			} else {
				model.addObject("msg", "You do not have access rights to view this page!");
			}
		} catch (Exception e) {
			System.out.println("Error in Loading Access Denied Page");
		}

		return model;
	}
	
	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndex(@ModelAttribute("user") UserDetails userDetail) {
		return getViewPage(userDetail);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public ModelAndView getAdmin(@ModelAttribute("user") UserDetails userDetail) {
		return getViewPage(userDetail);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/request",method = RequestMethod.GET)
	public ModelAndView getProcess(@ModelAttribute("user") UserDetails userDetail) {
		return getViewPage(userDetail);
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = "/process",method = RequestMethod.GET)
	public ModelAndView getRequest(@ModelAttribute("user") UserDetails userDetail) {
		return getViewPage(userDetail);
	}

	private ModelAndView getViewPage(@ModelAttribute("user") UserDetails userDetail) {
		
		userDetail = loggedInUserDetails();
		return new ModelAndView("commons/homePage", "user", userDetail);
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/j_spring_security_logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "commons/login";
	}
	
}
