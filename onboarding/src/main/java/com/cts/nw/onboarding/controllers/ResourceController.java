/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bean.AjaxResponse;
import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.ResourceService;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends AbstractController {

	Logger log = Logger.getLogger(ResourceController.class) ;
	
	@Autowired
	ResourceService resourceService;

	@RequestMapping(value = "/getemployee", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getEmployeeFromLDAP(@RequestParam("empId") String empId) {
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			EmployeeDetails employee = resourceService.getEmployee(empId);
			if (employee != null) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				ajaxResponse.setResponseObj(employee);

			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(empId + ErrorConstants.LDAPERROR);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.ERROR_MSG);
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}

	@GetMapping(value = "/list")
	public ModelAndView getAllEmployees(ModelMap model) {
		ModelAndView modelView = null;
		try {
			modelView = bindViewwithUserInfo("resources/resourceList");
		} catch (Exception e) {
			modelView = bindViewwithUserInfo("errors/errorPage");
			modelView.addObject("errMessage", e.getMessage());
			log.error(e.getMessage());
		}
		return modelView;
	}

	@RequestMapping(value = "/getemployeelist")
	public @ResponseBody Map<String, List<EmployeeMaster>> getListOfResource() {
		Map<String, List<EmployeeMaster>> employeeMap = new HashMap<>();
		List<EmployeeMaster> employeeList = new ArrayList<>();
		try {
			employeeList = resourceService.getAllResources();
			employeeMap.put("data", employeeList);
		} catch (Exception e) {
			employeeMap.put("data", employeeList);
			log.error(e.getMessage());
		}
		return employeeMap;
	}
	
	@GetMapping(value = "/find")
    public ModelAndView generateSearchForm(String empId) {
           ModelAndView modelView = null;
           try {
                  modelView = bindViewwithUserInfo("resources/findResource");
           } catch (Exception e) {
                  modelView = bindViewwithUserInfo("errors/errorPage");
                  modelView.addObject("errMessage", e.getMessage());
                  log.error(e.getMessage());
           }
           return modelView;
    }

	@GetMapping(value = "/getresourcedetails/{empId}")
    public ModelAndView findById(@PathVariable String empId) {
           ModelAndView modelView = null;
           try {
                  modelView = bindViewwithUserInfo("resources/resourceProjectDetails");
                  modelView.addObject("employees", resourceService.getEmployeeProjDetails(empId));
           } catch (CustomException e) {
                  modelView = bindViewwithUserInfo("errors/errorPage");
                  modelView.addObject("errMessage", e.getMessage());
                  log.error(e.getMessage());
           }
           return modelView;
    }
}
