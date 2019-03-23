/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bean.AppInfo;
import com.cts.nw.onboarding.service.LDAPService;

/**
 * @author 656579
 *
 */
@Controller
public class AbstractController {

	@Autowired
	LDAPService lDAPService;
	
	public static AppInfo APPINFO = new AppInfo();

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		setDateFormat(binder, dateFormat, "dateOfBirth");
		setDateFormat(binder, dateFormat, "startDate");
		setDateFormat(binder, dateFormat, "nationwideIdCreatedDate");
		setDateFormat(binder, dateFormat, "fgOnBoardingDate");
		setDateFormat(binder, dateFormat, "releaseDate");
	}

	/**
	 * @param binder
	 * @param dateFormat
	 * @param dateField
	 */
	private void setDateFormat(WebDataBinder binder, SimpleDateFormat dateFormat, String dateField) {
		binder.registerCustomEditor(Date.class, dateField, new CustomDateEditor(dateFormat, true));
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	
	/**
	 * 
	 */
	@ModelAttribute
	public void setApplicationInfo(HttpServletRequest request) {
		setAppUrl(request);
		setLoggedinUserInfo();
	}

	/**
	 * 
	 */
	private void setLoggedinUserInfo() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			if (authentication != null) {
				String currentUserName = authentication.getName();
				Collection<? extends GrantedAuthority> currentUserNameAuthorities = authentication.getAuthorities();
				if (currentUserName.equalsIgnoreCase("admin")) {
					APPINFO.setLoggedInUserId(currentUserName);
					APPINFO.setLoggedInUserName(currentUserName);
					for (GrantedAuthority auth : currentUserNameAuthorities) {
						APPINFO.setLoggedInUserRole(auth.getAuthority().replaceAll("ROLE_", ""));
					}
				} else {
					APPINFO.setLoggedInUserId(currentUserName);
					/*APPINFO.setLoggedInUserName(lDAPService.getEmployee(currentUserName) != null
							? lDAPService.getEmployee(currentUserName).getName() : "User");*/
					APPINFO.setLoggedInUserName("User");
					for (GrantedAuthority auth : currentUserNameAuthorities) {
						APPINFO.setLoggedInUserRole(auth.getAuthority().replaceAll("ROLE_", ""));
					}
				}
			}
		}
	}

	/**
	 * @param request
	 */
	private void setAppUrl(HttpServletRequest request) {
		if (request.getLocalPort() != 0) {
			APPINFO.setAppUrl(request.getServerName() + ":" + request.getLocalPort() + request.getContextPath());
		} else {
			APPINFO.setAppUrl(request.getServerName() + request.getContextPath());
		}
	}

	/**
	 * @param request
	 */
	protected ModelAndView bindViewwithUserInfo(String viewPage) {
		ModelAndView modelView = null;
		modelView = new ModelAndView(viewPage);
		modelView.addObject("appInfo", APPINFO);
		return modelView;
	}

}
