/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bean.AjaxResponse;
import com.cts.nw.onboarding.bo.BSA;
import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.service.BSAService;
import com.cts.nw.onboarding.service.TeamService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/team")
public class TeamController extends AbstractController {

	Logger log = Logger.getLogger(TeamController.class);

	@Autowired
	TeamService teamService;

	@Autowired
	BSAService bSAService;

	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getactiveteams", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllTeamDetails() {
		List<Teams> teamList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			teamList = teamService.getAllTeams();
			if (teamList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(teamList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(ErrorConstants.EMPTY_LIST);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.ERROR_MSG);
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}

	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getactivebsa", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllBSADetails() {
		List<BSA> basList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			basList = bSAService.getActiveBsaDetails();
			if (basList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(basList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(ErrorConstants.EMPTY_LIST);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.ERROR_MSG);
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}

}
