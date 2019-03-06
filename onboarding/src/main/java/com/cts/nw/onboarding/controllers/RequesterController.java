/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		/*List<EmployeeMaster> empList = employeeMasterDAO.getAllEmployeeMasterDetails();
		
		for(EmployeeMaster emp : empList){
			System.out.println("In Emp Loop" + emp);
		}
		System.out.println("In");*/
		System.out.println("In Index");
		return "request/checkResourceAvailability";
	}
	
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/request/check/{empid}", method = RequestMethod.GET)
	public String index(Model model,@PathVariable String empid) {
		/*List<EmployeeMaster> empList = employeeMasterDAO.getAllEmployeeMasterDetails();
		for(EmployeeMaster emp : empList){
			System.out.println("In Emp Loop" + emp);
		}*/
		//employeeMasterDAO.getEmployeeMasterDetailsByID(Integer.parseInt(empid));
		System.out.println("In");
		return "request/checkResourceAvailability";
	}
}
