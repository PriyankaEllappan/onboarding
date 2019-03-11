/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.vo.EmployeeDetails;

/**
 * @author 616550
 *
 */
public interface LDAPService {
	EmployeeDetails getEmployee(String empIdtoSearch);
}
