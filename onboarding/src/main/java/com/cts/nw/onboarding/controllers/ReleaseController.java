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

import com.cts.nw.onboarding.bo.ProcessorsInfo;
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
	@RequestMapping(value = "/processrelease/{projInfoId}", method = RequestMethod.GET)
	public String generateReleaseProcessForm(@ModelAttribute("employee") ProcessorsInfo employee,
			@PathVariable String projInfoId, ModelMap model) {
		try {
			employee = releaseService.getEmployeetoReleasebyId(projInfoId);
			System.out.println(employee.toString());
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
			return releaseService.getAllReleaseSummary();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statList;
	}
}
