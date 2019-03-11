/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeRelease;

/**
 * @author 616550
 *
 */
public interface EmployeeReleaseDAO {
	

		List<EmployeeRelease> getEmployeeReleaseDetails(int employeeID,String releaseStatus);
	}

