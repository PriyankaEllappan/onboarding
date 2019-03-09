package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ProcessorsInfo;

public interface ProcessorsInfoDAO {

	List<ProcessorsInfo> getRecordsPerProcessor(int processorid);

	ProcessorsInfo getEmployeeToProcess(int processorid, int employeeProjectInfoID);

	List<ProcessorsInfo> getEmployeesbyReleaseStatusId(int releaseStatusID);

	ProcessorsInfo getEmployeestoReleasebyId(int empProjInfoId);
}
