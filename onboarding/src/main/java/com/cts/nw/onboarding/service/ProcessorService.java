/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;

/**
 * @author 656579
 *
 */
public interface ProcessorService {


	List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid);
	
	EmployeeProjHist onboardAnEmployee(EmployeeProjHist employeeProjHist);
	
	List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid);

	EmployeeProjHist offboardAnEmployee(EmployeeProjHist employeeProjHist);
	
	EmployeeProjHist getEmployeeDetails(String empProjHistId);

}
