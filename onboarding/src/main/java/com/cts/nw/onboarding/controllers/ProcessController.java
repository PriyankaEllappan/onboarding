/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.ProcessorsInfo;
import com.cts.nw.onboarding.service.ProcessorService;

/**
 * @author 656579
 *
 */
@Controller
public class ProcessController {

	@Autowired
	ProcessorService processorService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/processrequest/{empprojid}", method = RequestMethod.GET)
	public String generateRequestProcessForm(@ModelAttribute("employee") ProcessorsInfo employee,
			@PathVariable String empprojid, ModelMap model,Principal principal) {
		String processor; 
		try {
			processor = getLoggedinUserDetails(principal);
			processor = "429992";
			employee = processorService.getEmployeetoProcess(processor,empprojid);
			System.out.println(employee.toString());
			model.addAttribute("employee", employee);
			return "process/requestProcessingForm";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/process/processupdate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody ProcessorsInfo assignProject(@RequestBody ProcessorsInfo employeeProjJson) {
		try {
			System.out.println(employeeProjJson.toString());
			return processorService.processAnEmployee(employeeProjJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param principal
	 * @param loggedInUserName
	 * @return
	 */
	private String getLoggedinUserDetails(Principal principal) {
		String loggedInUserName = null;
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
}
