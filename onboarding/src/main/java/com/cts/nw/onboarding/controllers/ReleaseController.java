package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.service.ReleaseService;
import com.cts.nw.onboarding.util.UserDetails;

@Controller
@RequestMapping("/release")
public class ReleaseController extends AbstractController {

	UserDetails user;

	public ReleaseController() {
		super();
		user = loggedInUserDetails();
	}

	@Autowired
	ReleaseService releaseService;

	/**
	 * @param resource
	 * @param empProjHistId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/requestrelease/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView generateReleaseProcessForm(@ModelAttribute("employee") EmployeeProjHist resource,
			@PathVariable("empProjHistId") String empProjHistId, Model model) {
		System.out.println(releaseService.getEmployeetoRelease(empProjHistId).toString());
		return new ModelAndView("terminate/requestTerminationForm", "employee",
				releaseService.getEmployeetoRelease(empProjHistId));
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
		System.out.println(employee.toString());
		ModelAndView modelAndView;
		try {
			releaseService.releaseAnEmployee(employee);
			modelAndView = new ModelAndView("detailsSaved");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("process/requestProcessingForm");
			return modelAndView;
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
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/list")
	public String getAllEmployees(ModelMap model) {
		try {
			return "resourcedetails/releaseList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/teamlist")
	public String getAllEmployeesbyTeam(ModelMap model) {
		try {
			return "resourcedetails/releaseList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/projectlist")
	public String getAllEmployeesbyProject(ModelMap model) {
		try {
			return "resourcedetails/releaseList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/resources", method = RequestMethod.GET)
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
}
