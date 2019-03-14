/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeMaster;

/**
 * @author 616550
 *
 */
public interface EmployeeMasterDAO {

	List<EmployeeMaster> getAllEmployeeMasterDetails();
	EmployeeMaster getEmployeeMasterDetailsByID(String id);
	Integer addNewResource(EmployeeMaster employeeMaster);
	
}
