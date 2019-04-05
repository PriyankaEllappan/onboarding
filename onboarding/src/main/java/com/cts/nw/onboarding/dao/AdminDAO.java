/**
 * 
 */
package com.cts.nw.onboarding.dao;

import com.cts.nw.onboarding.bean.User;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface AdminDAO {

	void registerUser(User user) throws CustomException;
}
