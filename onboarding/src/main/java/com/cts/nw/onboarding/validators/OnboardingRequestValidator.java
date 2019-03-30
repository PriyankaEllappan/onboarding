/**
 * 
 */
package com.cts.nw.onboarding.validators;

import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.constants.ValidationConstants;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;

/**
 * @author 656579
 *
 */
@Service
public class OnboardingRequestValidator {

	Logger log = Logger.getLogger(OnboardingRequestValidator.class);

	public boolean validate(EmployeeProjHist employeeProjHist) throws ValidatorException, CustomException {
		try {
			if (employeeProjHist.getExperience() != null && employeeProjHist.getExperience() < 0) {
				throw new ValidatorException(ValidationConstants.EXPERIENCEVALIDATION);
			}
			if (employeeProjHist.getSkillSet() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getSkillSet())) {
				System.out.println("Skillset Validation Failed");
				return false;
			}
			if (employeeProjHist.getSkillSummary() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getSkillSummary())) {
				System.out.println("Skill summary Validation Failed");
				return false;
			}
			if (employeeProjHist.getPplManager() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getPplManager())) {
				System.out.println("PPL Validation Failed");
				return false;
			}
			if (employeeProjHist.getNationwideId() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getNationwideId())) {
				System.out.println("NationwideId Validation Failed");
				return false;
			}
			if (employeeProjHist.getWorkForceId() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getWorkForceId())) {
				System.out.println("WorkForceId Validation Failed");
				return false;
			}
			if (employeeProjHist.getScrumMaster() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getScrumMaster())) {
				System.out.println("ScrumMaster Validation Failed");
				return false;
			}
			if (employeeProjHist.getApm() != null && !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getApm())) {
				System.out.println("Apm Validation Failed");
				return false;
			}
			if (employeeProjHist.getComments() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getComments())) {
				System.out.println("Comments Validation Failed");
				return false;
			}
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		return true;
	}

}
