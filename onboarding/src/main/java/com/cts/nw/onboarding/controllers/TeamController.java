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

import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.service.TeamService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController extends AbstractController {

	@Autowired
	TeamService teamService;

	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getactiveteams", method = RequestMethod.GET)
	public @ResponseBody List<Teams> getAllTeamDetails() {
		List<Teams> teamList = null;
		try {
			teamList = teamService.getAllTeams();
			if (teamList.size() > 0) {
				return teamList;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
