/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.ProcessorsInfo;
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
	@RequestMapping(value = "/process/processrequest/{empid}", method = RequestMethod.GET)
	public String generateRequestProcessForm(@ModelAttribute("employee") ProcessorsInfo employee,
			@PathVariable int empid, ModelMap model) {
		Integer processorId = 429992;
		try {
			//employee = processorService.getEmployeetoProcess(processorId,empid);
			employee = new ProcessorsInfo();
			System.out.println(employee.toString());
			model.addAttribute("employee", employee);
			return "process/requestProcessingForm";
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
	public @ResponseBody ProcessorsInfo assignProject(@RequestBody ProcessorsInfo employeeProjJson) {
		try {
			System.out.println(employeeProjJson.toString());
			return processorService.processAnEmployee(employeeProjJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
