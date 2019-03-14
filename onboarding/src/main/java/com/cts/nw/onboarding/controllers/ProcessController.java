/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.service.ProcessorService;

/**
 * @author 656579
 *
 */
@Controller
public class ProcessController extends AbstractController{

	@Autowired
	ProcessorService processorService;
	
	/**
	 * Displays the Update Form.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/processrequest/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView showUpdateForm(@ModelAttribute("employee") EmployeeProjHist resource, @PathVariable("empProjHistId") String empProjHistId,
			Model model) {
		System.out.println(processorService.getEmployeetoProcess(empProjHistId).toString());
		return new ModelAndView("process/requestProcessingForm", "employee", processorService.getEmployeetoProcess(empProjHistId));
	}
	
	/**
	 * Updates the Resource Details
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/processupdate", method = RequestMethod.POST)
	public ModelAndView updateResource(@ModelAttribute("employee") EmployeeProjHist employee,
			BindingResult result) {
		System.out.println(employee.toString());
		
		processorService.processAnEmployee(employee);
		System.out.println("Completed");
		/*ModelAndView modelAndView = null;
		if (result.hasErrors()) {
			modelAndView = new ModelAndView("processUpdate");
			return modelAndView;
		} else {
			processService.updateResource(resource);
			modelAndView = new ModelAndView("detailsSaved");
		    modelAndView.addObject("resource", processService.findResource(resource, resource.getEmpId()));
			return modelAndView;
		}*/
		return null;
	}
	
	/**
	 * @param employeeJson
	 * @return
	 *//*
	@PostMapping(value = "/process/processupdate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeProjHist assignProject(@RequestBody EmployeeProjHist employeeProjJson) {
		try {
			System.out.println(employeeProjJson.toString());
			return processorService.processAnEmployee(employeeProjJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}*/
	
	@GetMapping(value = "/process/processlist", produces = { MediaType.APPLICATION_JSON_VALUE })
	public String getAllEmployeestoProcess(ModelMap model) {
		String processorId = "429992";
		try {
			model.addAttribute("employees", processorService.getRecordsPerProcessor(processorId));
			return "resourcedetails/processList";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	} 
}
