/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;

/**
 * @author 656579
 *
 */
public interface ProcessorService {


	List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid) throws CustomException;
	
	EmployeeProjHist onboardAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException, ValidatorException;
	
	List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid) throws CustomException;

	EmployeeProjHist offboardAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException;
	
	EmployeeProjHist getEmployeeDetails(String empProjHistId) throws CustomException;

}
