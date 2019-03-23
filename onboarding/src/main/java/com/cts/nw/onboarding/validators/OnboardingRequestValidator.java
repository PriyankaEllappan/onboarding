/**
 * 
 */
package com.cts.nw.onboarding.validators;

import java.util.regex.Pattern;

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
		if(!Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getSkillSet())){
			return false;
		}
		return true;
	}

}
