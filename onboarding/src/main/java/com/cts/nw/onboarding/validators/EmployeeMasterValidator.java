/**
 * 
 */
package com.cts.nw.onboarding.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.constants.ValidationConstants;
import com.cts.nw.onboarding.exception.ValidatorException;

/**
 * @author 656579
 *
 */
@Service
public class EmployeeMasterValidator {

	public boolean validate(EmployeeMaster employee) throws ValidatorException  {
		
			if (employee.getEmployeeId() == null || employee.getEmployeeId() <= 0) {
				throw new ValidatorException(ValidationConstants.EMPLOYEEIDVALIDATION);
			}
			if (employee.getFirstName() == null || !Pattern.matches("[a-zA-Z0-9\\s]*", employee.getFirstName())) {
				throw new ValidatorException(ValidationConstants.FIRSTNAMEVALIDATION);
			}
			if (employee.getLastName() == null || !Pattern.matches("[a-zA-Z0-9\\s]*", employee.getLastName())) {
				throw new ValidatorException(ValidationConstants.LASTNAMEVALIDATION);
			}
			if (employee.getName() == null || !Pattern.matches("[a-zA-Z0-9\\s]*", employee.getName())) {
				throw new ValidatorException(ValidationConstants.EMPLOYEENAMEVALIDATION);
			}
			if (employee.getPassportNumber() == null || employee.getPassportNumber().length() != 4) {
				throw new ValidatorException(ValidationConstants.PASSPORTVALIDATION);
			}
			if (employee.getDateOfBirth() == null) {
				throw new ValidatorException(ValidationConstants.DATEOFBIRTHVALIDATION);
			}
			if (employee.getEmail() == null || !Pattern
					.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", employee.getEmail())) {
				throw new ValidatorException(ValidationConstants.EMAILIDVALIDATION);
			}
		return true;
	}
}
