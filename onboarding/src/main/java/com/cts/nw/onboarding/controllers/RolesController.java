/**
 * 
 *//*
package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.bo.Roles;
import com.cts.nw.onboarding.dao.RoleMappingDAO;
import com.cts.nw.onboarding.dao.RolesDAO;

*//**
 * @author 656579
 *
 *//*
@Controller
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	RoleMappingDAO roleMappingDAO;
	
	@Autowired
	RolesDAO rolesDAO;
	
	*//**
	 * @param teamname
	 * @return
	 *//*
	@RequestMapping(value = "/getAllRoleMappings", method = RequestMethod.GET)
	public @ResponseBody List<RoleMapping> getAllRoleMappings() {
		return roleMappingDAO.getAllRoleMappingDetails();
	}
	
	*//**
	 * @param teamname
	 * @return
	 *//*
	@RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
	public @ResponseBody List<Roles> getAllRoles() {
		return rolesDAO.getAllRoles();
	}
}
*/