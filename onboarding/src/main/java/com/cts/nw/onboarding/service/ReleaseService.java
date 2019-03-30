package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;

/**
 * @author 656579
 *
 */
public interface ReleaseService {

	List<EmployeeProjHist> getEmployeestobeReleased() throws CustomException;

	EmployeeProjHist getEmployeetoRelease(String empProjHistId) throws CustomException;

	List<ReleaseSummary> getAllReleaseSummary() throws CustomException;

	List<EmployeeProjHist> getEmployeestobeReleasedbyId(String empID) throws CustomException;
	
	List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId) throws CustomException;

	List<EmployeeProjHist> getEmployeestobeReleasedbyProject(String projectId) throws CustomException;
	
	Integer releaseAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException, ValidatorException;

	Integer releaseEmployeesByTeam(EmployeeProjHist employeeJson) throws CustomException, ValidatorException;

	Integer releaseEmployeesByProject(EmployeeProjHist employeeJson) throws CustomException, ValidatorException;

}
