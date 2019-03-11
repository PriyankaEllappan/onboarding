/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeActiveAssignment;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjectInfo;

/**
 * @author 656579
 *
 */
public interface RequesterService {

	public EmployeeMaster checkEmployeeAvailability(String empid);
	public EmployeeMaster addNewResource(EmployeeMaster employee);
	public EmployeeMaster populateRequesterForm(int empid);
	public EmployeeProjectInfo addNewProject(EmployeeProjectInfo employeeProjJson);
	public List<EmployeeActiveAssignment> checkforActiveAssignment(String empid);
	public List<EmployeeMaster> getAllEmployees();
	
}
