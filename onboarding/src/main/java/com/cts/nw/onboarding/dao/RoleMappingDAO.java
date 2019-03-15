/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.bo.Roles;

/**
 * @author 616550
 *
 */
public interface RoleMappingDAO {

	List<RoleMapping> getAllRoleMappingDetails();
	List<Roles> getRoleDetails();
}
