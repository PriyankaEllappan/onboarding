/**
 * 
 */
package com.cts.nw.onboarding.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;

/**
 * @author 656579
 *
 */
@Service
public class EmployeeMasterValidator {

	public boolean validate(EmployeeMaster employee) throws ValidatorException, CustomException {
		try {
			if (employee.getEmployeeId() <= 0) {
				throw new ValidatorException("Employee ID Cant be Negative");
			}
			if (employee.getFirstName() == null || !Pattern.matches("[a-zA-Z0-9\\s]*", employee.getFirstName())) {
				throw new ValidatorException("First Name can only contain alphabets");
			}
			if (employee.getLastName() == null || !Pattern.matches("[a-zA-Z0-9\\s]*", employee.getLastName())) {
				throw new ValidatorException("Last Name can only contain alphabets");
			}
			if (employee.getName() == null || !Pattern.matches("[a-zA-Z0-9\\s]*", employee.getName())) {
				throw new ValidatorException("Employee Name can only contain alphabets");
			}
			if (employee.getPassportNumber() == null || employee.getPassportNumber().length() != 4) {
				throw new ValidatorException("Passport or SSN Number should be Numeric and 4 digits long");
			}
			if (employee.getDateOfBirth() == null) {
				throw new ValidatorException("Date of Birth Can't be empty");
			}
			if (employee.getEmail() == null || !Pattern
					.matches("^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", employee.getEmail())) {
				throw new ValidatorException("Invalid Email ID Entered");
			}
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		return true;
	}
}
