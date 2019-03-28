/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.bo.Roles;
import com.cts.nw.onboarding.service.RoleService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController extends AbstractController {
	
	Logger log = Logger.getLogger(RoleController.class) ;

	@Autowired
	RoleService roleService;

	/**
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getrolemappings", method = RequestMethod.GET)
	public @ResponseBody List<RoleMapping> getAllRoleMappings() {
		List<RoleMapping> roleMappingList;
		try {
			roleMappingList = roleService.getAllRoleMappings();
			if (roleMappingList.size() > 0) {
				return roleMappingList;
			} else {
				return null;
			}

		} catch (Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getroles", method = RequestMethod.GET)
	public @ResponseBody Map<String, List<Roles>> getAllRoles() {
		Map<String, List<Roles>> roleList;
		try {
			roleList = roleService.getRoleDetails();
			if (roleList.size() > 0) {
				return roleList;
			} else {
				return null;
			}

		} catch (Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}
}
