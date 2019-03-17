/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ProcessController extends AbstractController {


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
	public ModelAndView showUpdateForm(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("process/requestProcessingForm");
		modelView.addObject("employee", processorService.getEmployeetoProcess(empProjHistId));
		return modelView;
	}

	/**
	 * Updates the Resource Details
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/processrequest", method = RequestMethod.POST)
	public ModelAndView updateResource(@ModelAttribute("employee") EmployeeProjHist employee, BindingResult result) {
		ModelAndView modelView;
		processorService.processAnEmployee(employee);
		modelView = bindViewwithUserInfo("commons/detailsSaved");
		modelView.addObject("employee", employee);
		return modelView;
	}

	
	/**
	 * Display the On board List. 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/process/onboardlist")
	public ModelAndView getAllEmployeestobeOnboarded(ModelMap model) {
		String processorId = "413804";
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("process/processList");
		modelView.addObject("employees", processorService.getRecordsPerProcessortoOnboard(processorId));
		return modelView;
	}
	
	
	/**
	 * Display the Off board List.
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/process/offboardlist")
	public ModelAndView getAllEmployeestobeOffboarded(ModelMap model) {
		String processorId = "413804";
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("process/processList");
		modelView.addObject("employees", processorService.getRecordsPerProcessortoOffboard(processorId));
		return modelView;
	}
	
}
