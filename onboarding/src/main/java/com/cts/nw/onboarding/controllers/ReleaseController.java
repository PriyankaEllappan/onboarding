package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.service.ReleaseService;

@Controller
@RequestMapping("/release")
public class ReleaseController {

	@Autowired
	ReleaseService releaseService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/processrelease/{empProjHistId}", method = RequestMethod.GET)
	public String generateReleaseProcessForm(@ModelAttribute("employee") EmployeeProjHist employee,
			@PathVariable String empProjHistId, ModelMap model) {
		try {
			employee = releaseService.getEmployeetoRelease(empProjHistId);
			model.addAttribute("employee", employee);
			return "terminate/requestTerminationForm";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
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
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/requestrelease", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeProjHist requestRelease(@RequestBody EmployeeProjHist employeeProjJson) {
		try {
			System.out.println(employeeProjJson.toString());
			return releaseService.releaseAnEmployee(employeeProjJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	 @GetMapping(value = "/releaselist", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String getAllEmployees(ModelMap model) {
		try {
			model.addAttribute("employees", releaseService.getEmployeestobeReleased());
			return "resourcedetails/releaseList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
