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
	List<EmployeeProjHist> getEmployeesPerRequester(String requesterId) throws CustomException;
	List<EmployeeProjHist> checkActiveAssignments(String empid) throws CustomException;
	Integer addEmployeeProjectInfo(EmployeeProjHist employeeProjectHist) throws CustomException;
	
	/*Processor Operations*/
	List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid) throws CustomException;
	Integer onBoardEmployee(EmployeeProjHist employeeProjectHist) throws CustomException;
	List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid) throws CustomException;
	Integer processOffboardEmployee(EmployeeProjHist employeeProjectHist, Integer Id) throws CustomException;
	
	/*Release Operations*/
	List<EmployeeProjHist> getEmployeestobeReleased() throws CustomException;
	List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId) throws CustomException;
	List<EmployeeProjHist> getEmployeestobeReleasedbyProj(String projectId) throws CustomException;
	Integer offboardEmployee(EmployeeProjHist employeeProjHist,Integer Id) throws CustomException;
	
	/*Common Operations*/
	EmployeeProjHist getSpecificEmployeeProjectHist(String empProjHistId) throws CustomException;
	List<EmployeeProjHist> getAllEmployeeProjectInfo() throws CustomException;
	
}
