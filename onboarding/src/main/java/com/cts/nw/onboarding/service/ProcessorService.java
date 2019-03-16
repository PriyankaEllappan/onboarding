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


	EmployeeProjHist getEmployeetoProcess(String empProjHistId);

	EmployeeProjHist processAnEmployee(EmployeeProjHist employeeProjHist);

	List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid);

	List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid);


}
