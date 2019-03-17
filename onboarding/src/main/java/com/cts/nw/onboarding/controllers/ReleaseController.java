package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.service.ReleaseService;

@Controller
@RequestMapping("/release")
public class ReleaseController extends AbstractController {

	@Autowired
	ReleaseService releaseService;

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
		modelView.addObject("employee", releaseService.getEmployeetoRelease(empProjHistId));
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
	public ModelAndView releaseResource(@ModelAttribute("employee") EmployeeProjHist employee, BindingResult result) {
		ModelAndView modelView;
		releaseService.releaseAnEmployee(employee);
		modelView = bindViewwithUserInfo("commons/detailsSaved");
		modelView.addObject("employee", employee);
		return modelView;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getreleasesummary", method = RequestMethod.GET)
	public @ResponseBody List<ReleaseSummary> getAllReleaseSummary() {
		List<ReleaseSummary> statList = null;
		try {
			return releaseService.getAllReleaseSummary();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statList;
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/releaselist", method = RequestMethod.POST)
	public ModelAndView releaseAllList() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("terminate/releaseList");
		return modelView;
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/releaselistbyteam", method = RequestMethod.POST)
	public ModelAndView releaseListbyTeam() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("terminate/releaseListbyTeam");
		return modelView;
	}
	
	/**
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/releaselistbyproject", method = RequestMethod.POST)
	public ModelAndView releaseListbyProj() {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("terminate/releaseListbyProj");
		return modelView;
	}
	
	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getresources", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeProjHist> getResourcesAvailableforRelease() {
		List<EmployeeProjHist> releaseList;
		try {
			releaseList = releaseService.getEmployeestobeReleased();
			if (releaseList.size() > 0) {
				return releaseList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getresourcesbyteam/{teamId}", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeProjHist> getResourcesbyTeam(@PathVariable("teamId") String teamId) {
		List<EmployeeProjHist> releaseList;
		try {
			releaseList = releaseService.getEmployeestobeReleasedbyTeam(teamId);
			if (releaseList.size() > 0) {
				return releaseList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/getresourcesbyproject/{projectId}", method = RequestMethod.GET)
	public @ResponseBody List<EmployeeProjHist> getResourcesAvailablebyProject(@PathVariable("projectId") String projectId) {
		List<EmployeeProjHist> releaseList;
		try {
			releaseList = releaseService.getEmployeestobeReleasedbyProject(projectId);
			if (releaseList.size() > 0) {
				return releaseList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
