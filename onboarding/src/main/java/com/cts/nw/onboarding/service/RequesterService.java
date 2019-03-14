/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeMaster;

/**
 * @author 656579
 *
 */
public interface RequesterService {

	EmployeeMaster getResourceByID(String employeeid);
	EmployeeMaster addNewResource(EmployeeMaster employee);
	List<EmployeeMaster> getAllEmployees();
	
}
