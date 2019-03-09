package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.ReleaseStatus;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.dao.ReleaseSummaryDAO;

@Controller
@RequestMapping("/release")
public class ReleaseController {

	@Autowired
	ReleaseSummaryDAO releaseSummaryDAO;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/processrelease/{empid}", method = RequestMethod.GET)
	public String generateRequestProcessForm(@ModelAttribute("employee") EmployeeMaster employee,
			@PathVariable int empid, ModelMap model) {
		try {
			employee = new EmployeeMaster();
		/*	employee = requesterService.populateRequesterForm(empid);*/
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
	@RequestMapping(value = "/getreasonsummary", method = RequestMethod.GET)
	public @ResponseBody List<ReleaseSummary> getAllReleaseSummary() {
		List<ReleaseSummary> statList = null;
		try {
			return releaseSummaryDAO.getAllReleaseSummary();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statList;
	}
}
