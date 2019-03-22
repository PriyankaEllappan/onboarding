/**
 * 
 */
package com.cts.nw.onboarding.validators;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeMaster;

/**
 * @author 656579
 *
 */
@Service
public class EmployeeMasterValidator {

	public boolean validate(EmployeeMaster employee) {
		if(employee.getEmployeeId() <= 0){
			return false;
		}
		if(!Pattern.matches("[a-zA-Z0-9\\s]*", employee.getFirstName())){
			return false;
		}
		if(!Pattern.matches("[a-zA-Z0-9\\s]*", employee.getLastName())){
			return false;
		}
		if(!Pattern.matches("[a-zA-Z0-9\\s]*", employee.getName())){
			return false;
		}
		if(employee.getPassportNumber() == null || employee.getPassportNumber().length() != 4){
			return false;
		}
		return true;
	}
}
