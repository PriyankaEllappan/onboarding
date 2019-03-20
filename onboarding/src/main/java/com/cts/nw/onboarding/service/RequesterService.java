/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjHist;

/**
 * @author 656579
 *
 */
public interface RequesterService {

	EmployeeMaster getResourceByID(String employeeid);
	EmployeeMaster addNewResource(EmployeeMaster employee);
	List<EmployeeMaster> getAllEmployees();
	EmployeeProjHist addNewProject(EmployeeProjHist employeeProjHist);
	List<EmployeeProjHist> checkActiveAssignments(String employeeid);
	List<EmployeeProjHist> getEmployeesPerRequester(String requesterId);
	EmployeeProjHist getEmployeeProjById(String empProjHistId);
	
}
