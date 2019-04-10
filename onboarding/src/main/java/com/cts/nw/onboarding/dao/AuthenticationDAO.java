/**
 * 
 */
package com.cts.nw.onboarding.dao;

import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface AuthenticationDAO {

	AuthenticationInfo getUserDetailsByID(String id) throws CustomException;

	Integer updateUserDetails(AuthenticationInfo authenticationInfo) throws CustomException;

}
