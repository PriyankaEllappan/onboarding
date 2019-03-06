package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeMaster;

public interface EmployeeMasterDAO{
	
	List<EmployeeMaster> getAllEmployeeMasterDetails();
	EmployeeMaster getEmployeeMasterDetailsByID(int id);
	
}