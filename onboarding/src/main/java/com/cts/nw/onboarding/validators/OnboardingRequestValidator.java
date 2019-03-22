/**
 * 
 */
package com.cts.nw.onboarding.validators;

import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;

/**
 * @author 656579
 *
 */
@Service
public class OnboardingRequestValidator {

	public boolean validate(EmployeeProjHist employeeProjHist) {
		if(employeeProjHist.getExperience() < 0){
			return false;
		}
		return true;
	}

}
