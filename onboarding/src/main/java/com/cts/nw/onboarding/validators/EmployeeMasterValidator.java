/**
 * 
 */
package com.cts.nw.onboarding.validators;

import java.util.Date;
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
				throw new ValidatorException(ValidationConstants.EMPID_ERR);
			}
			if (employee.getFirstName() == null || !Pattern.matches("[a-zA-Z.\\s]*", employee.getFirstName())) {
				throw new ValidatorException(ValidationConstants.FNAME_ERR);
			}
			if (employee.getLastName() == null || !Pattern.matches("[a-zA-Z.\\s]*", employee.getLastName())) {
				throw new ValidatorException(ValidationConstants.LNAME_ERR);
			}
			if (employee.getName() == null || !Pattern.matches("[a-zA-Z.\\s]*", employee.getName())) {
				throw new ValidatorException(ValidationConstants.NAME_ERR);
			}
			if (employee.getPassportNumber() == null || employee.getPassportNumber().length() != 4) {
				throw new ValidatorException(ValidationConstants.PASSPORT_ERR);
			}
			if (employee.getDateOfBirth() == null || employee.getDateOfBirth().after(new Date())) {
				throw new ValidatorException(ValidationConstants.DOB_ERR);
			}
			if (employee.getEmail() == null || !Pattern
					.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", employee.getEmail())) {
				throw new ValidatorException(ValidationConstants.EMAIL_ERR);
			}
		return true;
	}
}
