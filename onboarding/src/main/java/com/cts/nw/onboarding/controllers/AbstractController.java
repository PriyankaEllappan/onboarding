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

import com.cts.nw.onboarding.util.UserDetails;

/**
 * @author 656579
 *
 */
@Controller
public class AbstractController {
	
	public static String APPURL = "";
	
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

	/**
	 * 
	 */
	public UserDetails loggedInUserDetails() {
		UserDetails userDetails = null;
		try {
			userDetails = new UserDetails();
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (!(authentication instanceof AnonymousAuthenticationToken)) {
				if(authentication != null){
					String currentUserName = authentication.getName();
					Collection<? extends GrantedAuthority> currentUserNameAuthorities = authentication.getAuthorities();
					userDetails.setLoggedInUser(currentUserName);
					userDetails.setLoggedInUserRole(currentUserNameAuthorities.toString());
					System.out.println(userDetails.toString());
				}
			} else {
				System.out.println("Please login to continue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDetails;
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
