package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface ReleaseService {

	List<EmployeeProjHist> getEmployeestobeReleased();

	EmployeeProjHist getEmployeetoRelease(String empProjHistId);

	List<ReleaseSummary> getAllReleaseSummary();

	List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId);

	List<EmployeeProjHist> getEmployeestobeReleasedbyProject(String projectId);
	
	Integer releaseAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException;

	Integer releaseEmployeesByTeam(EmployeeProjHist employeeJson);

	Integer releaseEmployeesByProject(EmployeeProjHist employeeJson);

}
