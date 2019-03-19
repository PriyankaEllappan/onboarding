
package com.cts.nw.onboarding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bean.AppInfo;

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
	public ModelAndView accesssDenied() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/accessDenied");
		modelView.addObject("msg", "You do not have access rights to view this page!");
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
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getIndex() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/homePage");
		return modelView;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView getAdmin(@ModelAttribute("appInfo") AppInfo appInfo) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/homePage");
		return modelView;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public ModelAndView getProcess(@ModelAttribute("appInfo") AppInfo appInfo) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/homePage");
		return modelView;
	}

	/**
	 * @return
	 */
	@RequestMapping(value = "/process", method = RequestMethod.GET)
	public ModelAndView getRequest(@ModelAttribute("appInfo") AppInfo appInfo) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/homePage");
		return modelView;
	}

}
