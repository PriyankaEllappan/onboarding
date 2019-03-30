/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;

/**
 * @author 656579
 *
 */
public interface RequesterService {

	List<EmployeeProjHist> getEmployeesPerRequester(String requesterId) throws CustomException;
	
	EmployeeMaster getResourceByID(String employeeid) throws CustomException;
	EmployeeMaster addNewResource(EmployeeMaster employee) throws CustomException, ValidatorException;
	EmployeeProjHist addNewProject(EmployeeProjHist employeeProjHist) throws CustomException;
	List<EmployeeProjHist> checkActiveAssignments(String employeeid) throws CustomException;
	EmployeeProjHist getEmployeeProjById(String empProjHistId) throws CustomException;
	
}
