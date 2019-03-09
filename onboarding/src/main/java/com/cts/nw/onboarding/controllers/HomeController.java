
package com.cts.nw.onboarding.controllers;

import java.security.Principal;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/")
public class HomeController {

	public static String APPURL = "";
	
	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home() {
		String homepageMessage = "Onboarding Application";
		return new ModelAndView("index", "message", homepageMessage);
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginError", method = RequestMethod.GET)
	public String loginError(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}
	
	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = null;
		try {
			model = new ModelAndView("accessDenied");
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
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping("/admin")
	public ModelAndView adminIndex(ModelMap model, Principal principal) {
		String loggedInUserName = null;
		loggedInUserName = getLoggedinUserDetails(principal, loggedInUserName);
		return new ModelAndView("homePage", "userName", loggedInUserName);
	}

	/**
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping("/request")
	public ModelAndView processIndex(ModelMap model, Principal principal) {
		String loggedInUserName = null;
		loggedInUserName = getLoggedinUserDetails(principal, loggedInUserName);
		return new ModelAndView("homePage", "userName", loggedInUserName);
	}
	
	/**
	 * @param model
	 * @param principal
	 * @return
	 */
	@RequestMapping("/process")
	public ModelAndView requestIndex(ModelMap model, Principal principal) {
		String loggedInUserName = null;
		loggedInUserName = getLoggedinUserDetails(principal, loggedInUserName);
		return new ModelAndView("homePage", "userName", loggedInUserName);
	}
	
	/**
	 * @param principal
	 * @param loggedInUserName
	 * @return
	 */
	private String getLoggedinUserDetails(Principal principal, String loggedInUserName) {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				String currentUserName = authentication.getName();
				Collection<? extends GrantedAuthority> currentUserNameAuthorities = authentication.getAuthorities();
				System.out.println("Logged in User :" + currentUserName);
				System.out.println("Logged in Role" + currentUserNameAuthorities.toString());
				if (principal.getName() != null) {
					loggedInUserName = principal.getName();
				} else {
					System.out.println("principal.getName() is null");
				}
			} else {
				System.out.println("Please login to continue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loggedInUserName;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/j_spring_security_logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "login";
	}

	@ModelAttribute
	public void setUrl(HttpServletRequest request){
		if(request.getLocalPort() != 0){
			APPURL = request.getServerName() + ":" + request.getLocalPort() + request.getContextPath();
		}else{
			APPURL = request.getServerName() + request.getContextPath();
		}
		System.out.println(APPURL);
	}
	
}
