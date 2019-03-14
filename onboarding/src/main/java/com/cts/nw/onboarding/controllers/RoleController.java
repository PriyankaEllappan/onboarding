/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.service.RoleService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService roleService;

	/**
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/getroles", method = RequestMethod.GET)
	public @ResponseBody List<RoleMapping> getAllRoleMappings() {
		List<RoleMapping> countryList;
		try {
			countryList = roleService.getAllRoleMappings();
			if (countryList.size() > 0) {
				return countryList;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
