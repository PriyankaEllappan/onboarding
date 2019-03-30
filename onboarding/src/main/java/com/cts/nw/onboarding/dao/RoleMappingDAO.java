/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.bo.Roles;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface RoleMappingDAO {

	List<RoleMapping> getAllRoleMappingDetails() throws CustomException;
	List<Roles> getRoleDetails() throws CustomException;
}
