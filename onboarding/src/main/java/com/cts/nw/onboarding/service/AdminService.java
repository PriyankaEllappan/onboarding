/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bean.User;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface AdminService {

	void registerUser(User user) throws CustomException;

}
