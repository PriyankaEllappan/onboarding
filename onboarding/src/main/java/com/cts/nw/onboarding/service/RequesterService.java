/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;
import com.cts.nw.onboarding.bo.EmployeeMaster;

/**
 * @author 656579
 *
 */
public interface RequesterService {

	public EmployeeMaster checkEmployeeAvailability(String empid);
	public EmployeeMaster addNewResource(EmployeeMaster employee);
	public EmployeeCompleteProjectInfo populateRequesterForm(EmployeeCompleteProjectInfo employee,int empid);
	
}
