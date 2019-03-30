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
			if (employeeProjHist.getPplManager() == null
					&& !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getPplManager())) {
				throw new ValidatorException(ValidationConstants.PPLVALIDATION);
			}
			if (employeeProjHist.getApm() == null && !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getApm())) {
				throw new ValidatorException(ValidationConstants.APMVALIDATION);
			}
			if (employeeProjHist.getNationwideId() != null
					&& !Pattern.matches("[a-zA-Z0-9]*", employeeProjHist.getNationwideId())) {
				throw new ValidatorException(ValidationConstants.NATIONWIDEIDVALIDATION);
			}
			if (employeeProjHist.getNationwideIdCreatedDate() == null) {
				throw new ValidatorException(ValidationConstants.NATIONWIDEIDCREATEDDATEVALIDATION);
			}
			if (employeeProjHist.getWorkForceId() == null
					&& !Pattern.matches("[a-zA-Z0-9]*", employeeProjHist.getWorkForceId())) {
				throw new ValidatorException(ValidationConstants.WORKFORCEIDVALIDATION);
			}
			if (employeeProjHist.getScrumMaster() == null
					&& !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getScrumMaster())) {
				throw new ValidatorException(ValidationConstants.SCRUMMASTERVALIDATION);
			}
			if (employeeProjHist.getFgOnBoardingDate() == null) {
				throw new ValidatorException(ValidationConstants.FGONBOARDINGDATEVALIDATION);
			}
			if (employeeProjHist.getComments() != null
					&& !Pattern.matches("[a-zA-Z0-9\\s]*", employeeProjHist.getComments())) {
				throw new ValidatorException(ValidationConstants.COMMENTSVALIDATION);
			}
			if (employeeProjHist.getStartDate() == null) {
				throw new ValidatorException(ValidationConstants.STARTDATEDATEVALIDATION);
			}
			if (employeeProjHist.getSkillSet() != null
					&& !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getSkillSet())) {
				throw new ValidatorException(ValidationConstants.SKILLSETVALIDATION);
			}
			if (employeeProjHist.getSkillSummary() != null
					&& !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getSkillSummary())) {
				throw new ValidatorException(ValidationConstants.SKILLSUMMARYVALIDATION);
			}
			if (employeeProjHist.getExperience() != null && employeeProjHist.getExperience() < 0) {
				throw new ValidatorException(ValidationConstants.EXPERIENCEVALIDATION);
			}
					
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		return true;
	}

}
