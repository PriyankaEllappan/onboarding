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

	List<EmployeeProjHist> getRecordsPerProcessor(int processorid);

	EmployeeProjHist getEmployeetoProcess(int empProjHistId);

	EmployeeProjHist processAnEmployee(EmployeeProjHist employeeProjHist);


}
