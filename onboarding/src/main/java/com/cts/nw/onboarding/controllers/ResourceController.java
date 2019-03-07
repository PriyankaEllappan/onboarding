/**
 * 
 */
package com.cts.nw.onboarding.controllers;

//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.util.LDAPUtil;
import com.cts.nw.onboarding.vo.EmployeeDetails;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

	//private static final Logger logger = Logger.getLogger(ResourceController.class);
	
	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public @ResponseBody EmployeeDetails index(@RequestParam("empId") String empId) {
		EmployeeDetails employee = new LDAPUtil().getEmployee("sAMAccountName", empId);
           return employee;
    }

	
}
