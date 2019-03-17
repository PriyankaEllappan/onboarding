/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.service.LDAPService;
import com.cts.nw.onboarding.util.EmployeeDetails;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends AbstractController {

	// private static final Logger logger = Logger.getLogger(ResourceController.class);
	
	@Autowired
	LDAPService lDAPService;

	@RequestMapping(value = "/getemployee", method = RequestMethod.GET)
	public @ResponseBody EmployeeDetails index(@RequestParam("empId") String empId) {
		EmployeeDetails employee = null;
		try {
			employee = lDAPService.getEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
