/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface ResourceService {

	EmployeeDetails getEmployee(String empId) throws CustomException;

	List<EmployeeMaster> getAllResources() throws CustomException;

	List<EmployeeProjHist> getEmployeeProjDetails(String empId) throws CustomException;

}
