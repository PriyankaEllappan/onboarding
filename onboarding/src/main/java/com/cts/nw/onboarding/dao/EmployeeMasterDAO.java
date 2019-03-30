/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface EmployeeMasterDAO {

	List<EmployeeMaster> getAllEmployeeMasterDetails() throws CustomException;
	EmployeeMaster getEmployeeMasterDetailsByID(String id) throws CustomException;
	Integer addNewResource(EmployeeMaster employeeMaster) throws CustomException;
	
}
