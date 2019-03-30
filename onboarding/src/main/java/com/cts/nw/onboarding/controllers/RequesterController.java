/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.apache.log4j.Logger;
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
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;
import com.cts.nw.onboarding.service.RequesterService;

/**
 * @author 656579
 *
 */
@Controller
public class RequesterController extends AbstractController {

	Logger log = Logger.getLogger(RequesterController.class);
	
	@Autowired
	RequesterService requesterService;
	
	@GetMapping(value = "/request/requestlist")
	public ModelAndView getAllEmployees(ModelMap model) {
		ModelAndView modelView = null;
		try {
			String requesterId = APPINFO.getLoggedInUserId();
			modelView = bindViewwithUserInfo("request/requestList");
			modelView.addObject("employees", requesterService.getEmployeesPerRequester(requesterId));
		} catch (CustomException e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e.getMessage());
		}
		return modelView;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check", method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelView;
		try {
			modelView = bindViewwithUserInfo("request/checkResourceAvailability");
		} catch (Exception e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e.getMessage());
		}
		return modelView;
	}

	/**
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/request/check/{empid}", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse employeeAvailability(@PathVariable String empid) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			EmployeeMaster employee = requesterService.getResourceByID(empid);
			if (employee != null) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				ajaxResponse.setResponseObj(employee);

			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.info(empid + "Employee Not available in nationwide. ");
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage("Exception Occurred.");
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/addresource", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody AjaxResponse createUser(@RequestBody EmployeeMaster employeeJson) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			EmployeeMaster employee = requesterService.addNewResource(employeeJson);
			if (employee != null) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				ajaxResponse.setResponseObj(employee);
				ajaxResponse.setStatusMessage("Resource Registered.");

			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				ajaxResponse.setStatusMessage("Resource Not Registered.");
			}
		} catch (ValidatorException e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(e.getMessage());
		} catch (CustomException e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage("Exception Occurred.");
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/mapproject/{empid}", method = RequestMethod.GET)
	public ModelAndView generateAddProjForm(@PathVariable("empid") String empid) {
		ModelAndView modelView = null;
		try {
			List<EmployeeProjHist> activeAssignment = checkActiveAssignment(empid);
			if (activeAssignment != null && activeAssignment.size() >= 2) {
				modelView = bindViewwithUserInfo("errors/assignmentsExceeded");
			} else {
				modelView = bindViewwithUserInfo("request/mapNewProject");
				modelView.addObject("employee", requesterService.getResourceByID(empid));
			}
		} catch (CustomException e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e.getMessage());
		}
		return modelView;
	}

	/**
	 * @param employeeJson
	 * @return
	 */
	@GetMapping(value = "/request/checkactiveassignments/{employeeid}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody List<EmployeeProjHist> checkActiveAssignment(@PathVariable String employeeid) {
		List<EmployeeProjHist> activeAssignment = null;
		try {
			activeAssignment = requesterService.checkActiveAssignments(employeeid);
		} catch (CustomException e) {
			log.error(e.getMessage());
		}
		return activeAssignment;
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
	public @ResponseBody AjaxResponse assignProject(@RequestBody EmployeeProjHist employeeProjJson, ModelMap model) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			EmployeeProjHist employee = requesterService.addNewProject(employeeProjJson);
			if (employee != null) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				ajaxResponse.setResponseObj(employee);
			}
		} catch (ValidatorException e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(e.getMessage());
		}
		catch (CustomException e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage("Exception Occurred.");
		}
		return ajaxResponse;
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
		try {
			modelView.addObject("employee", requesterService.getEmployeeProjById(empProjHistId));
		} catch (CustomException e) {
			modelView = new ModelAndView("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
		}
		return modelView;
	}
	
}
