/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;

/**
 * @author 656579
 *
 */
@Controller
public class RequesterController {

	@Autowired
	private EmployeeMasterDAO employeeMasterDAO;
	
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
	public @ResponseBody EmployeeMaster employeeAvailability(Model model,@PathVariable String empid) {
		Integer employeeId;
		EmployeeMaster employee = new EmployeeMaster();
		try {
			employeeId = Integer.parseInt(empid);
			System.out.println("Employee to be found:" + employeeId);
			return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@RequestMapping(value = "/request/addResource/", method = RequestMethod.POST)
	public @ResponseBody String createUser(@RequestBody EmployeeMaster employeeJson) {
		String message = "";
		try{
			Integer rowsAffected;
			rowsAffected = employeeMasterDAO.addEmployeeMaster(employeeJson);
			if( rowsAffected > 0){
				message = "Employee details saved successfully";
			}
			return message;
		}catch(Exception e){
			message = "Error in iserting Employee Details";
			return message;
		}
		
	}
	
	/**
	 * @param employeeJson
	 * @return
	 */
	@RequestMapping(value = "/request/mapProject/", method = RequestMethod.POST)
	public @ResponseBody String addProject(@RequestBody EmployeeMaster employeeJson) {
		String message = "";
		/*try{
			Integer rowsAffected;
			rowsAffected = 
			if( rowsAffected > 0){
				message = "Project details saved successfully";
			}
			return message;
		}catch(Exception e){
			message = "Error in iserting Project Details";
			return message;
		}*/
		return message;
	}
	
	
}
