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
			System.out.println("Exp Validation Failed");
			return false;
		}
		if(employeeProjHist.getSkillSet() != null && !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getSkillSet())){
			System.out.println("Skillset Validation Failed");
			return false;
		}
		if(employeeProjHist.getSkillSummary() != null && !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getSkillSummary())){
			System.out.println("Skill summary Validation Failed");
			return false;
		}
		if(employeeProjHist.getPplManager() != null && !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getPplManager())){
			System.out.println("PPL Validation Failed");
			return false;
		}
		return true;
	}

}
