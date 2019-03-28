/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface EmployeeProjHistDAO {

	/*Requester Operations*/
	List<EmployeeProjHist> getEmployeesPerRequester(String requesterId);
	List<EmployeeProjHist> checkActiveAssignments(String empid);
	Integer addEmployeeProjectInfo(EmployeeProjHist employeeProjectHist) throws CustomException;
	
	/*Processor Operations*/
	List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid);
	Integer onBoardEmployee(EmployeeProjHist employeeProjectHist) throws CustomException;
	List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid);
	Integer processOffboardEmployee(EmployeeProjHist employeeProjectHist, Integer Id) throws CustomException;
	
	/*Release Operations*/
	List<EmployeeProjHist> getEmployeestobeReleased();
	List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId);
	List<EmployeeProjHist> getEmployeestobeReleasedbyProj(String projectId);
	Integer offboardEmployee(EmployeeProjHist employeeProjHist,Integer Id) throws CustomException;
	
	/*Common Operations*/
	EmployeeProjHist getSpecificEmployeeProjectHist(String empProjHistId);
	List<EmployeeProjHist> getAllEmployeeProjectInfo();
	
}
