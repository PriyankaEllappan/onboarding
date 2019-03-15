/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		ModelAndView modelAndView;
		try {
			processorService.processAnEmployee(employee);
			modelAndView = new ModelAndView("detailsSaved");
			return modelAndView;
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("process/requestProcessingForm");
			return modelAndView;
		}
	}
		
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
