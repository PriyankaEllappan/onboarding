/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public AuthenticationInfo getUserDetailsByID(String id) throws CustomException{
		return authenticationDAO.getUserDetailsByID(id);
	};

	public Integer updateUserDetails(AuthenticationInfo authenticationInfo) throws CustomException{
		return authenticationDAO.updateUserDetails(authenticationInfo);
	};
	
}
