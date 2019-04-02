/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bean.AjaxResponse;
import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.service.LDAPService;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends AbstractController {

	Logger log = Logger.getLogger(ResourceController.class) ;
	
	@Autowired
	LDAPService lDAPService;

	@RequestMapping(value = "/getemployee", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getEmployeeFromLDAP(@RequestParam("empId") String empId) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			EmployeeDetails employee = lDAPService.getEmployee(empId);
			
			if (employee != null) {
				System.out.println(employee.toString());
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				ajaxResponse.setResponseObj(employee);

			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(empId + ErrorConstants.LDAPERROR);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.ERROR_MSG);
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}

}
