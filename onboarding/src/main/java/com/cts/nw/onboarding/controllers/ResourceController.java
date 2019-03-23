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

import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.service.LDAPService;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends AbstractController {

	@Autowired
	LDAPService lDAPService;

	@RequestMapping(value = "/getemployee", method = RequestMethod.GET)
	public @ResponseBody EmployeeDetails index(@RequestParam("empId") String empId) {
		return lDAPService.getEmployee(empId);
	}

}
