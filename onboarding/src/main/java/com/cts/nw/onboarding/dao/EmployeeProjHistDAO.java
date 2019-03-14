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
	int addEmployeeProjectInfo(EmployeeProjHist employeeProjectHist);
	List<EmployeeProjHist> checkActiveAssignments(String empid);
	
	/*Processor Operations*/
	List<EmployeeProjHist> getRecordsPerProcessor(int processorid);
	
	/*Release Operations*/
	List<EmployeeProjHist> getEmployeestobeReleased();
	
	/*Common Operations*/
	EmployeeProjHist getSpecificEmployeeProjectHist(int empProjHistId);
	Integer updateSpecificEmployeeProjectHist(EmployeeProjHist employeeProjectHist);
	List<EmployeeProjHist> getAllEmployeeProjectInfo();
}
