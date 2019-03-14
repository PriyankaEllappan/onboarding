/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.security.Principal;

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
import com.cts.nw.onboarding.service.ProcessorService;

/**
 * @author 656579
 *
 */
@Controller
public class ProcessController {

	@Autowired
	ProcessorService processorService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/process/processrequest/{empProjHistId}", method = RequestMethod.GET)
	public String generateRequestProcessForm(@ModelAttribute("employee") EmployeeProjHist employee,
			@PathVariable String empProjHistId, ModelMap model,Principal principal) {
		try {
			employee = processorService.getEmployeetoProcess(empProjHistId);
			if(employee != null){
				System.out.println(employee.toString());
				model.addAttribute("employee", employee);
				return "process/requestProcessingForm";
			}else{
				model.addAttribute("employee", employee);
				return "commons/resourceNotAvailable";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/process/processupdate", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeProjHist assignProject(@RequestBody EmployeeProjHist employeeProjJson) {
		try {
			System.out.println(employeeProjJson.toString());
			return processorService.processAnEmployee(employeeProjJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
