package com.cts.nw.onboarding.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bean.AjaxResponse;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.ReleaseService;

@Controller
@RequestMapping("/release")
public class ReleaseController extends AbstractController {

	Logger log = Logger.getLogger(ReleaseController.class);

	@Autowired
	ReleaseService releaseService;

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/releaselist", method = RequestMethod.GET)
	public ModelAndView releaseAllList() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("terminate/releaseList");
		try {
			modelView.addObject("employees", releaseService.getEmployeestobeReleased());
		} catch (CustomException e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
		}
		return modelView;
	}

	/**
	 * @param resource
	 * @param empProjHistId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/requestrelease/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView generateReleaseProcessForm(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("terminate/requestTerminationForm");
		try {
			modelView.addObject("employee", releaseService.getEmployeetoRelease(empProjHistId));
		} catch (CustomException e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
		}
		return modelView;
	}

	/**
	 * Updates the Resource Details
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/processrelease", method = RequestMethod.POST)
	public ModelAndView releaseResource(@ModelAttribute("employee") EmployeeProjHist employeeJson,
			BindingResult result) {
		try {
			releaseService.releaseAnEmployee(employeeJson);
			return releaseAllList();
		} catch (CustomException e) {
			ModelAndView modelView;
			modelView = new ModelAndView("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e.getMessage());
			return modelView;
		}
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/releaselistbyteam", method = RequestMethod.GET)
	public ModelAndView releaseListbyTeam() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("terminate/releaseListbyTeam");
		return modelView;
	}

	/**
	 * Updates the Resource Details
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @return
	 */
	@PostMapping(value = "/processreleasebyteam")
	public String releaseResourcebyTeam(@RequestBody EmployeeProjHist employeeJson) {
		try {
			releaseService.releaseEmployeesByTeam(employeeJson);
		} catch (CustomException e) {
			log.error(e.getMessage());
		}
		return "redirect:releaselist";
	}

	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/releaselistbyproject", method = RequestMethod.GET)
	public ModelAndView releaseListbyProj() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("terminate/releaseListbyProj");
		return modelView;
	}

	/**
	 * Updates the Resource Details
	 * 
	 * @param id
	 * @param model
	 * @return
	 * @return
	 */
	@PostMapping(value = "/processreleasebyproject")
	public String releaseResourcebyProject(@RequestBody EmployeeProjHist employeeJson) {
		try {
			releaseService.releaseEmployeesByProject(employeeJson);
		} catch (CustomException e) {
			log.error(e.getMessage());
		}
		return "redirect:releaselist";
	}

	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getresourcesbyteam/{teamId}", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getResourcesbyTeam(@PathVariable("teamId") String teamId) {
		List<EmployeeProjHist> releaseList;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			releaseList = releaseService.getEmployeestobeReleasedbyTeam(teamId);
			if (releaseList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(releaseList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.COMMONERROR);
		}
		return ajaxResponse;
	}

	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getresourcesbyproject/{projectId}", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getResourcesAvailablebyProject(@PathVariable("projectId") String projectId) {
		List<EmployeeProjHist> releaseList;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			releaseList = releaseService.getEmployeestobeReleasedbyProject(projectId);
			if (releaseList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(releaseList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.COMMONERROR);
		}
		return ajaxResponse;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getreleasesummary", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllReleaseSummary() {
		List<ReleaseSummary> summaryList;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			summaryList = releaseService.getAllReleaseSummary();
			if (summaryList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(summaryList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.COMMONERROR);
		}
		return ajaxResponse;
	}

	/**
	 * Displays the Resource Details.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/show/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView showResource(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/showResource");
		try {
			modelView.addObject("employee", releaseService.getEmployeetoRelease(empProjHistId));
		} catch (CustomException e) {
			log.error(e.getMessage());
		}
		return modelView;
	}
}
