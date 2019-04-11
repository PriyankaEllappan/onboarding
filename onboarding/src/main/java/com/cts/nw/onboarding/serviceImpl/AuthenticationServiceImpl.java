/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.dao.AuthenticationDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.AuthenticationService;

/**
 * @author 656579
 *
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationDAO authenticationDAO;
	
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
			AuthenticationInfo currUserDetails = authenticationDAO.getUserDetailsByID(authenticationInfo.getUserName());
			if (currUserDetails != null) {
				String existingPassword = authenticationInfo.getCurrPassword();
				String dbPassword = currUserDetails.getCurrPassword();
				if (passwordEncoder.matches(existingPassword, dbPassword)) {
					System.out.println("Matched");
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
		} catch (ValidationException e) {
			throw new ValidationException(e.getMessage());
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}
	
}
