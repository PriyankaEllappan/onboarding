/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface RequesterService {

	List<EmployeeProjHist> getEmployeesPerRequester(String requesterId);
	
	EmployeeMaster getResourceByID(String employeeid);
	EmployeeMaster addNewResource(EmployeeMaster employee) throws CustomException;
	EmployeeProjHist addNewProject(EmployeeProjHist employeeProjHist) throws CustomException;
	List<EmployeeProjHist> checkActiveAssignments(String employeeid);
	EmployeeProjHist getEmployeeProjById(String empProjHistId);
	
}
