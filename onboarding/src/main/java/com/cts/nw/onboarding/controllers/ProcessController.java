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
	@RequestMapping(value = "/process/onboard/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView showOnboardForm(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("process/onboardProcessingForm");
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
	@RequestMapping(value = "/process/onboard", method = RequestMethod.POST)
	public ModelAndView onboardResource(@ModelAttribute("employee") EmployeeProjHist employee, BindingResult result) {
		ModelAndView modelView;
		System.out.println(employee.toString());
		processorService.onboardAnEmployee(employee);
		modelView = bindViewwithUserInfo("commons/detailsSaved");
		modelView.addObject("employee", employee);
		return modelView;
	}

	/**
	 * Displays the Update Form.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/offboard/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView showOffboardForm(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("process/offboardProcessingForm");
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
	@RequestMapping(value = "/process/offboard", method = RequestMethod.POST)
	public ModelAndView offboardResource(@ModelAttribute("employee") EmployeeProjHist employee, BindingResult result) {
		ModelAndView modelView;
		System.out.println(employee.toString());
		processorService.offboardAnEmployee(employee);
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
		modelView = bindViewwithUserInfo("process/onboardProcessList");
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
		modelView = bindViewwithUserInfo("process/offboardProcessList");
		modelView.addObject("employees", processorService.getRecordsPerProcessortoOffboard(processorId));
		return modelView;
	}
	
	/**
	 * Displays the Update Form.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/show/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView showResource(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		modelView = bindViewwithUserInfo("commons/showResource");
		modelView.addObject("employee", processorService.getEmployeetoProcess(empProjHistId));
		return modelView;
	}
}
