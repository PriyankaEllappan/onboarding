/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.util.AppInfo;

/**
 * @author 656579
 *
 */
@Controller
public class AbstractController {

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

	/**
	 * 
	 */
	@ModelAttribute
	public void setApplicationInfo(HttpServletRequest request) {
		try {
			System.out.println("In Logged in User :" + APPINFO.toString());
			setAppUrl(request);
			setLoggedinUserInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Out Logged in User :" + APPINFO.toString());
	}

	/**
	 * 
	 */
	private void setLoggedinUserInfo() {
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				if (authentication != null) {
					String currentUserName = authentication.getName();
					Collection<? extends GrantedAuthority> currentUserNameAuthorities = authentication.getAuthorities();
					APPINFO.setLoggedInUser(currentUserName);
					APPINFO.setLoggedInUserRole(currentUserNameAuthorities.toString());
				}
			} else {
				System.out.println("Please login to continue");
			}
		} catch (Exception e) {

		}
	}

	/**
	 * @param request
	 */
	private void setAppUrl(HttpServletRequest request) {
		try {
			if (request.getLocalPort() != 0) {
				APPINFO.setAppUrl(request.getServerName() + ":" + request.getLocalPort() + request.getContextPath());
			} else {
				APPINFO.setAppUrl(request.getServerName() + request.getContextPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param request
	 */
	protected ModelAndView bindViewwithUserInfo(String viewPage) {
		ModelAndView modelView = null;
		try {
			modelView = new ModelAndView(viewPage);
			modelView.addObject("appInfo", APPINFO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelView;
	}
	
	
}
