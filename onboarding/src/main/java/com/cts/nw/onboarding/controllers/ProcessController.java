/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.nw.onboarding.bo.EmployeeMaster;

/**
 * @author 656579
 *
 */
@Controller
public class ProcessController {

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/processrequest/{empid}", method = RequestMethod.GET)
	public String generateRequestProcessForm(@ModelAttribute("employee") EmployeeMaster employee,
			@PathVariable int empid, ModelMap model) {
		try {
			employee = new EmployeeMaster();
		/*	employee = requesterService.populateRequesterForm(empid);*/
			model.addAttribute("employee", employee);
			return "process/requestProcessingForm";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
