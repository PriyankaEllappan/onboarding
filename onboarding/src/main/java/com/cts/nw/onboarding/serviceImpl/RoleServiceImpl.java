/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.RoleMapping;
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

	
}
