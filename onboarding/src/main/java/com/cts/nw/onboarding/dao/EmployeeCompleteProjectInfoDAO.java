package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeCompleteProjectInfo;

public interface EmployeeCompleteProjectInfoDAO {
	
	EmployeeCompleteProjectInfo getAllEmployeeCompleteProjectInfoDetailsByID(int employeeid);

	List<EmployeeCompleteProjectInfo> getAllEmployeeCompleteProjectInfoDetails();


}
