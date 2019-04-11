
package com.cts.nw.onboarding.controllers;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bean.AjaxResponse;
import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.AuthenticationService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/")
public class HomeController extends AbstractController {

	@Autowired
	AuthenticationService authenticationService;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "commons/login";
	}

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("errors/accessDenied");
		return modelView;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/j_spring_security_logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "commons/login";
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public ModelAndView changepassword(ModelMap model) {
		ModelAndView modelView = new ModelAndView("commons/changePassword");
		modelView.addObject("authInfo", new AuthenticationInfo());
		return modelView;
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ModelAndView checkAndUpdatePassword(@ModelAttribute("authInfo") AuthenticationInfo authInfo, BindingResult result) {
		ModelAndView modelView = null;
		try {
			authenticationService.updateUserDetails(authInfo);
			modelView = new ModelAndView("commons/passwordSuccess");
		} catch (ValidationException e) {
			modelView = new ModelAndView("commons/changePassword");
			modelView.addObject("errMessage", e.getMessage());
		} catch (CustomException e) {
			modelView = new ModelAndView("commons/changePassword");
			modelView.addObject("errMessage", e.getMessage());
		}
		return modelView;
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/generatepin/{empid}", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse generateMailPin(@PathVariable String empid) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		String generatedMailPin;
		String encodedPin;
		try {
			generatedMailPin = authenticationService.generateMailPin(empid);
			encodedPin = passwordEncoder.encode(generatedMailPin);
			ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
			ajaxResponse.setResponseObj(encodedPin);
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.ERROR_MSG);
		}
		return ajaxResponse;
	}
	
	/**
	 * @return
	 */
	@RequestMapping(value = {"/", "/admin","/request","/process"},method = RequestMethod.GET)
	public ModelAndView getIndex() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/homePage");
		return modelView;
	}
	
}
