/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;

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

import com.cts.nw.onboarding.bo.EmployeeActiveAssignment;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.service.RequesterService;

/**
 * @author 656579
 *
 */
@Controller
public class RequesterController {

	@Autowired
	RequesterService requesterService;

    @GetMapping(value = "/request/resourcelist", produces = { MediaType.APPLICATION_JSON_VALUE })
    public String getAllEmployees(ModelMap model) {
           try {
        	   model.addAttribute("resources", requesterService.getAllEmployees()); 
        	   return "resourcedetails/resourceList";
           } catch (Exception e) {
                  e.printStackTrace();
                  return null;
           }
    }
        
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check", method = RequestMethod.GET)
	public String index() {
		return "request/checkResourceAvailability";
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check/{empid}", method = RequestMethod.GET)
	public @ResponseBody EmployeeMaster employeeAvailability(@PathVariable String empid) {
		EmployeeMaster employee = null;
		try {
			return requesterService.checkEmployeeAvailability(empid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/addresource", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeMaster createUser(@RequestBody EmployeeMaster employeeJson) {
		try {
			return requesterService.addNewResource(employeeJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
    /**
    * @param employeeJson
    * @return
    */
    @GetMapping(value = "/request/checkActiveAssignment/{empid}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody List<EmployeeActiveAssignment> checkActiveAssignment(@PathVariable String empid) {
           try {
        	    return requesterService.checkforActiveAssignment(empid);
           } catch (Exception e) {
                  e.printStackTrace();
                  return null;
           }
    }

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/mapproject/{empid}", method = RequestMethod.GET)
	public String generateAddProjForm(@ModelAttribute("employee") EmployeeMaster employee,
			@PathVariable int empid, ModelMap model) {
		try {
			employee = requesterService.populateRequesterForm(empid);
			model.addAttribute("employee", employee);
			return "request/mapNewProject";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@PostMapping(value = "/request/addproject", produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody EmployeeProjectInfo assignProject(@RequestBody EmployeeProjectInfo employeeProjJson) {
		try {
			System.out.println(employeeProjJson.toString());
			return requesterService.addNewProject(employeeProjJson);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
