/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.bo.Roles;
import com.cts.nw.onboarding.dao.RoleMappingDAO;
import com.cts.nw.onboarding.service.RoleService;

/**
 * @author 656579
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	RoleMappingDAO roleMappingDAO;
	
	@Override
	public List<RoleMapping> getAllRoleMappings() {
		return roleMappingDAO.getAllRoleMappingDetails();
	}

	@Override
	public Map<String, List<Roles>> getRoleDetails() {
		Map<String, List<Roles>> roleCategory = new HashMap<>();
		List<Roles> roleList = roleMappingDAO.getRoleDetails();
		roleCategory =  roleList.stream().collect(Collectors.groupingBy(Roles::getParentRole));
		return roleCategory;
	}

	
}
