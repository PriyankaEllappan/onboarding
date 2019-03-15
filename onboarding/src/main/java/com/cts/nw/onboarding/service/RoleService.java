/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.bo.Roles;

/**
 * @author 656579
 *
 */
public interface RoleService {

	List<RoleMapping> getAllRoleMappings();
	List<Roles> getRoleDetails();
}
