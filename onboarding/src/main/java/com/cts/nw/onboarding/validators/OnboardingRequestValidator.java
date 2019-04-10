/**
 * 
 */
package com.cts.nw.onboarding.validators;

import java.util.regex.Pattern;

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

	/**
	 * @param employeeProjHist
	 * @return
	 * @throws ValidatorException
	 * @throws CustomException
	 */
	public boolean validateRequesterForm(EmployeeProjHist employeeProjHist) throws ValidatorException  {
			if (employeeProjHist.getTeamName() == null
					|| !Pattern.matches("[a-zA-Z,\\-&\\s]*", employeeProjHist.getTeamName())) {
				throw new ValidatorException(ValidationConstants.TEAMNAME_ERR);
			}
			if (employeeProjHist.getStartDate() == null) {
				throw new ValidatorException(ValidationConstants.STRDATE_ERR);
			}
			if (employeeProjHist.getSkillSet() == null
					|| !Pattern.matches("[a-zA-Z0-9,.+\\s]*", employeeProjHist.getSkillSet())) {
				throw new ValidatorException(ValidationConstants.SKILL_ERR);
			}
			if (employeeProjHist.getSkillSummary() == null
					|| !Pattern.matches("[a-zA-Z0-9,.+\\s]*", employeeProjHist.getSkillSummary())) {
				throw new ValidatorException(ValidationConstants.SUMMARY_ERR);
			}
			if (employeeProjHist.getExperience() == null || employeeProjHist.getExperience() < 0) {
				throw new ValidatorException(ValidationConstants.EXP_ERR);
			}
			if (employeeProjHist.getPplManager() == null
					&& !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getPplManager())) {
				throw new ValidatorException(ValidationConstants.PPL_ERR);
			}
		
		return true;
	}

	/**
	 * @param employeeProjHist
	 * @return
	 * @throws ValidatorException
	 * @throws CustomException
	 */
	public boolean validateProcessorForm(EmployeeProjHist employeeProjHist) throws ValidatorException {
		
			if (employeeProjHist.getPplManager() != null
					&& !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getPplManager())) {
				throw new ValidatorException(ValidationConstants.PPL_ERR);
			}
			if (employeeProjHist.getApm() != null && !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getApm())) {
				throw new ValidatorException(ValidationConstants.APM_ERR);
			}
			if (employeeProjHist.getNationwideId() != null
					&& !Pattern.matches("[a-zA-Z0-9]*", employeeProjHist.getNationwideId())) {
				throw new ValidatorException(ValidationConstants.NWID_ERR);
			}
			if (employeeProjHist.getWorkForceId() != null
					&& !Pattern.matches("[a-zA-Z0-9]*", employeeProjHist.getWorkForceId())) {
				throw new ValidatorException(ValidationConstants.WORKFORCE_ERR);
			}
			if (employeeProjHist.getScrumMaster() != null
					&& !Pattern.matches("[a-zA-Z\\s]*", employeeProjHist.getScrumMaster())) {
				throw new ValidatorException(ValidationConstants.SCRUMMASTER_ERR);
			}
			if (employeeProjHist.getComments() != null
					&& !Pattern.matches("[a-zA-Z0-9,.\\s]*", employeeProjHist.getComments())) {
				throw new ValidatorException(ValidationConstants.COMMENTS_ERR);
			}
		return true;
	}

	/**
	 * @param employeeProjHist
	 * @return
	 * @throws ValidatorException
	 * @throws CustomException
	 */
	public boolean validateReleaseForm(EmployeeProjHist employeeProjHist) throws ValidatorException{
		
			if (employeeProjHist.getReleaseStatusId() == null) {
				throw new ValidatorException(ValidationConstants.RELEASESTATUSVALIDATION);
			}
			if (employeeProjHist.getReasonForOffboarding() == null) {
				throw new ValidatorException(ValidationConstants.RELEASESUMMARYVALIDATION);
			}
			if (employeeProjHist.getReleaseDate() == null) {
				throw new ValidatorException(ValidationConstants.RELEASEDATEVALIDATION);
			}
		return true;
	}

}
