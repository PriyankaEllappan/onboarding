/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface ProcessorService {


	List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid);
	
	EmployeeProjHist onboardAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException;
	
	List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid);

	EmployeeProjHist offboardAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException;
	
	EmployeeProjHist getEmployeeDetails(String empProjHistId);

}
