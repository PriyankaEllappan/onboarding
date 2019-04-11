/**
 * 
 */
package com.cts.nw.onboarding.service;

import javax.xml.bind.ValidationException;

import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface AuthenticationService {

	AuthenticationInfo getUserDetailsByID(String id) throws CustomException;
	Integer updateUserDetails(AuthenticationInfo authenticationInfo) throws CustomException, ValidationException;
	
}
