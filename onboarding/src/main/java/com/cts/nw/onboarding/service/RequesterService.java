/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjectInfo;

/**
 * @author 656579
 *
 */
public interface RequesterService {

	public EmployeeMaster checkEmployeeAvailability(String empid);
	public EmployeeMaster addNewResource(EmployeeMaster employee);
	public EmployeeMaster populateRequesterForm(EmployeeMaster employee,int empid);
	public EmployeeProjectInfo addNewProject(EmployeeProjectInfo employeeProjJson);
	
}
