/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;

/**
 * @author 616550
 *
 */
public interface EmployeeProjHistDAO {

	/*Requester Operations*/
	Integer addEmployeeProjectInfo(EmployeeProjHist employeeProjectHist);
	List<EmployeeProjHist> checkActiveAssignments(String empid);
	List<EmployeeProjHist> getEmployeesPerRequester(String requesterId);
	
	/*Processor Operations*/
	List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid);
	List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid);
	
	/*Release Operations*/
	List<EmployeeProjHist> getEmployeestobeReleased();
	List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId);
	List<EmployeeProjHist> getEmployeestobeReleasedbyProj(String projectId);
	
	/*Common Operations*/
	EmployeeProjHist getSpecificEmployeeProjectHist(String empProjHistId);
	Integer updateSpecificEmployeeProjectHist(EmployeeProjHist employeeProjectHist);
	List<EmployeeProjHist> getAllEmployeeProjectInfo();
	
}
