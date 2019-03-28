/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.BSA;
import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.service.BSAService;
import com.cts.nw.onboarding.service.TeamService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController extends AbstractController {
	
	Logger log = Logger.getLogger(TeamController.class) ;

	@Autowired
	TeamService teamService;

	@Autowired
	BSAService bSAService;
	
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
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getactivebsa", method = RequestMethod.GET)
	public @ResponseBody List<BSA> getAllBSADetails() {
		List<BSA> basList = null;
		try {
			basList = bSAService.getActiveBsaDetails();
			if (basList.size() > 0) {
				return basList;
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
