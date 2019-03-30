/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;
import java.util.Map;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.bo.Roles;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface RoleService {

	List<RoleMapping> getAllRoleMappings() throws CustomException;
	Map<String, List<Roles>> getRoleDetails() throws CustomException;
}
