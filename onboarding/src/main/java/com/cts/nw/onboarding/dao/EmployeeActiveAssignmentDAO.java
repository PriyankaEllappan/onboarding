/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeActiveAssignment;

/**
 * @author 616550
 *
 */
public interface EmployeeActiveAssignmentDAO {
	

		List<EmployeeActiveAssignment> getEmployeeReleaseDetails(int employeeID,String releaseStatus);
	}

