/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.apache.log4j.Logger;
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
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;
import com.cts.nw.onboarding.service.ProcessorService;

/**
 * @author 656579
 *
 */
@Controller
public class ProcessController extends AbstractController {

	String listPage;
	
	Logger log = Logger.getLogger(ProcessController.class);
	
	@Autowired
	ProcessorService processorService;
	
	/*1. Perform the On boarding operations*/
	
	/**
	 * Display the On board List. 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/process/onboardlist")
	public ModelAndView getAllEmployeestobeOnboarded(ModelMap model) {
		String processorId;
		ModelAndView modelView;
		try {
			modelView = bindViewwithUserInfo("process/onboardProcessList");
			processorId = APPINFO.getLoggedInUserId();
			modelView.addObject("employees", processorService.getRecordsPerProcessortoOnboard(processorId));
			listPage = "onboardlist";
		} catch (CustomException e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
		}
		return modelView;
	}

	/**
	 * Displays the Onboard Update Form.
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/onboard/{empProjHistId}", method = RequestMethod.GET)
	public ModelAndView showOnboardForm(@PathVariable("empProjHistId") String empProjHistId) {
		ModelAndView modelView;
		try {
			modelView = bindViewwithUserInfo("process/onboardProcessingForm");
			modelView.addObject("employee", processorService.getEmployeeDetails(empProjHistId));
		} catch (CustomException e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
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
	@RequestMapping(value = "/process/onboard", method = RequestMethod.POST)
	public ModelAndView onboardResource(@ModelAttribute("employee") EmployeeProjHist employee, BindingResult result) {
		ModelAndView modelView;
		try {
			processorService.onboardAnEmployee(employee);
			modelView = bindViewwithUserInfo("commons/detailsSaved");
			modelView.addObject("employee", employee);
			return modelView;
		}  catch (ValidatorException e) {
			modelView = bindViewwithUserInfo("process/onboardProcessingForm");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
		} catch (CustomException e) {
			modelView = new ModelAndView("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
		}
		return modelView;
	}

	/*2. Perform the Off boarding operations*/
	
	/**
	 * Display the Off board List.
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/process/offboardlist")
	public ModelAndView getAllEmployeestobeOffboarded(ModelMap model) {
		String processorId;
		ModelAndView modelView;
		try {
			processorId = APPINFO.getLoggedInUserId();
			modelView = bindViewwithUserInfo("process/offboardProcessList");
			modelView.addObject("employees", processorService.getRecordsPerProcessortoOffboard(processorId));
			listPage = "offboardlist";
		} catch (CustomException e) {
			modelView = new ModelAndView("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
		}
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
		try {
			modelView = bindViewwithUserInfo("process/offboardProcessingForm");
			modelView.addObject("employee", processorService.getEmployeeDetails(empProjHistId));
		} catch (CustomException e) {
			modelView = new ModelAndView("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
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
	@RequestMapping(value = "/process/offboard", method = RequestMethod.POST)
	public ModelAndView offboardResource(@ModelAttribute("employee") EmployeeProjHist employee, BindingResult result) {
		ModelAndView modelView;
		try {
			processorService.offboardAnEmployee(employee);
			modelView = bindViewwithUserInfo("commons/detailsSaved");
			modelView.addObject("employee", employee);
		}  catch (ValidatorException e) {
			modelView = bindViewwithUserInfo("process/offboardProcessingForm");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
		}
		catch (CustomException e) {
			modelView = new ModelAndView("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
		}
		return modelView;
		
	}
	
	
	/*3. Display the Resource Information*/
	
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
		try {
			modelView = bindViewwithUserInfo("commons/showResource");
			modelView.addObject("employee", processorService.getEmployeeDetails(empProjHistId));
			modelView.addObject("list", listPage);
		} catch (CustomException e) {
			modelView = new ModelAndView("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e);
		}
		return modelView;
	}
}
