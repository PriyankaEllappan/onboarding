/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.util.EmployeeDetails;

/**
 * @author 616550
 *
 */
public interface LDAPService {
	EmployeeDetails getEmployee(String empIdtoSearch);
}
