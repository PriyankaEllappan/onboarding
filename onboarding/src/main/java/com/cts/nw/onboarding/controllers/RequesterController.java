/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bean.AjaxResponse;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.service.RequesterService;

/**
 * @author 656579
 *
 */
@Controller
public class RequesterController extends AbstractController {

	@Autowired
	RequesterService requesterService;
	
	@GetMapping(value = "/request/requestlist")
	public ModelAndView getAllEmployees(ModelMap model) {
		String requesterId = APPINFO.getLoggedInUserId();
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("request/requestList");
		modelView.addObject("employees", requesterService.getEmployeesPerRequester(requesterId));
		return modelView;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("request/checkResourceAvailability");
		return modelView;
	}

	/**
	 * @param model
	 * @return
	 *//*
	@RequestMapping(value = "/request/check/{empid}", method = RequestMethod.GET)
	public @ResponseBody EmployeeMaster employeeAvailability(@PathVariable String empid) {
		return requesterService.getResourceByID(empid);
	}*/

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check/{empid}", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse employeeAvailability(@PathVariable String empid) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		try{
			EmployeeMaster employee = requesterService.getResourceByID(empid);
			if(employee != null){
				ajaxResponse.setStatus("success");
				ajaxResponse.setResponseObj(employee);
			}else{
				ajaxResponse.setStatus("success");
				ajaxResponse.setResponseObj(new EmployeeMaster());
			}
		}catch(Exception e){
			ajaxResponse.setStatus("failure");
			ajaxResponse.setStatusMessage("Exception Occurred.");
		}
		return ajaxResponse;
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/addresource", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeMaster createUser(@RequestBody EmployeeMaster employeeJson) {
		return requesterService.addNewResource(employeeJson);
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/mapproject/{empid}", method = RequestMethod.GET)
	public ModelAndView generateAddProjForm(@PathVariable("empid") String empid) {
		ModelAndView modelView;
		List<EmployeeProjHist> activeAssignment = checkActiveAssignment(empid);
		if (activeAssignment != null && activeAssignment.size() >= 2) {
			modelView = bindViewwithUserInfo("errors/assignmentsExceeded");
		} else {
			modelView = bindViewwithUserInfo("request/mapNewProject");
			modelView.addObject("employee", requesterService.getResourceByID(empid));
		}
		
		return modelView;
	}

	/**
	 * @param employeeJson
	 * @return
	 */
	@GetMapping(value = "/request/checkactiveassignments/{employeeid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<EmployeeProjHist> checkActiveAssignment(@PathVariable String employeeid) {
		List<EmployeeProjHist> activeAssignment;
		activeAssignment = requesterService.checkActiveAssignments(employeeid);
		if (activeAssignment != null && !activeAssignment.isEmpty()) {
			return activeAssignment;
		} else {
			return null;
		}
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/assignmentexceeded", method = RequestMethod.GET)
	public ModelAndView moreAssignments() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("errors/assignmentsExceeded");
		return modelView;
	}
	
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/mapproject", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeProjHist assignProject(@RequestBody EmployeeProjHist employeeProjJson,ModelMap model) {
		return requesterService.addNewProject(employeeProjJson);
	}

	/**
	 * Displays the Update Form.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/show/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView showResource(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/showResource");
		modelView.addObject("employee", requesterService.getEmployeeProjById(empProjHistId));
		return modelView;
	}
	
}
