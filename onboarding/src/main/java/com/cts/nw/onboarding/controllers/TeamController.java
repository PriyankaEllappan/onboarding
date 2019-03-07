/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.TeamProjectHierarchy;
import com.cts.nw.onboarding.dao.TeamProjectHierarchyDAO;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/teams")
public class TeamController {

	@Autowired
	TeamProjectHierarchyDAO teamSelectDAO;
	
	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getTeamHierarchyDetails/{teamname}", method = RequestMethod.GET)
	public @ResponseBody List<TeamProjectHierarchy> getSelectedTeamDetails(@PathVariable String teamname) {
		return teamSelectDAO.getSelectedTeamDetails(teamname);
	}

	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getAllTeamDetails", method = RequestMethod.GET)
	public @ResponseBody List<TeamProjectHierarchy> getAllTeamDetails() {
		return teamSelectDAO.getAllTeamDetails();
	}
	
}
