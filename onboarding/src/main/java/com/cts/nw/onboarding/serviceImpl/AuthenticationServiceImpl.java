/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.UUID;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.bean.EmployeeDetails;
import com.cts.nw.onboarding.dao.AuthenticationDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.AuthenticationService;
import com.cts.nw.onboarding.service.LDAPService;
import com.cts.nw.onboarding.service.MailService;

/**
 * @author 656579
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationDAO authenticationDAO;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	LDAPService lDAPService;
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.AuthenticationService#getUserDetailsByID(java.lang.String)
	 */
	public AuthenticationInfo getUserDetailsByID(String id) throws CustomException{
		return authenticationDAO.getUserDetailsByID(id);
	};

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.service.AuthenticationService#updateUserDetails(com.cts.nw.onboarding.bean.AuthenticationInfo)
	 */
	public Integer updateUserDetails(AuthenticationInfo authenticationInfo)
			throws CustomException, ValidationException {
		try {
			Integer rowsAffected = 0;
			AuthenticationInfo currUserDetails;
			String existingPassword;
			String dbPassword;
			String mailPin = authenticationInfo.getMailPin();
			String hiddenPin = authenticationInfo.getHiddenPin();
			if (passwordEncoder.matches(mailPin, hiddenPin)) {
				currUserDetails = authenticationDAO.getUserDetailsByID(authenticationInfo.getUserName());
				if (currUserDetails != null) {
					existingPassword = authenticationInfo.getCurrPassword();
					dbPassword = currUserDetails.getCurrPassword();
					if (passwordEncoder.matches(existingPassword, dbPassword)) {
						rowsAffected = authenticationDAO.updateUserDetails(authenticationInfo);
						if (rowsAffected > 0) {
							return rowsAffected;
						} else {
							throw new ValidationException("Error while updating the password");
						}
					} else {
						throw new ValidationException("Current Password doesn't match. Please try again");
					}
				} else {
					throw new ValidationException("Specified User doesn't available in database");
				}
			} else {
				throw new ValidationException("Mail Pin doesn't Match. Please try again");
			}
		} catch (ValidationException e) {
			throw new ValidationException(e.getMessage());
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	@Override
	public String generateMailPin(String empid) throws CustomException {
		try {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String generatedMailPIN;
			AuthenticationInfo authenticationInfo = new AuthenticationInfo();
			generatedMailPIN = uuid.substring(0, 6);
			authenticationInfo.setUserName(empid);
			authenticationInfo.setMailPin(generatedMailPIN);
			mailService.sendMailPin(authenticationInfo);
			return generatedMailPIN;
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

	@Override
	public EmployeeDetails getEmployee(String empId) {
		return lDAPService.getEmployee(empId);
	}
	
}
