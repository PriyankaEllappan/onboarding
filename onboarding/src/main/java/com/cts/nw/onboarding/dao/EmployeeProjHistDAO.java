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
	
	/*Processor Operations*/
	List<EmployeeProjHist> getRecordsPerProcessor(String processorid);
	
	/*Release Operations*/
	List<EmployeeProjHist> getEmployeestobeReleased();
	
	/*Common Operations*/
	EmployeeProjHist getSpecificEmployeeProjectHist(String empProjHistId);
	Integer updateSpecificEmployeeProjectHist(EmployeeProjHist employeeProjectHist);
	List<EmployeeProjHist> getAllEmployeeProjectInfo();
}
