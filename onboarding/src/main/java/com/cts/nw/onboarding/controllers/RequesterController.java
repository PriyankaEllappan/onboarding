/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.service.RequesterService;

/**
 * @author 656579
 *
 */
@Controller
public class RequesterController {

	@Autowired
	RequesterService requesterService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check", method = RequestMethod.GET)
	public String index() {
		return "request/checkResourceAvailability";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check/{empid}", method = RequestMethod.GET)
	public @ResponseBody EmployeeMaster employeeAvailability(@PathVariable String empid) {
		EmployeeMaster employee = null;
		try {
			return requesterService.checkEmployeeAvailability(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/addresource", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeMaster createUser(@RequestBody EmployeeMaster employeeJson) {
		try {
			return requesterService.addNewResource(employeeJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/mapproject/{empid}", method = RequestMethod.GET)
	public String generateAddProjForm(@ModelAttribute("employee") EmployeeCompleteProjectInfo employee,
			@PathVariable int empid, ModelMap model) {
		try {
			requesterService.populateRequesterForm(employee, empid);
			model.addAttribute("employee", employee);
			return "request/mapNewProject";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
