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
import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.service.ProjectService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/projects")
public class ProjectController extends AbstractController {
	
	Logger log = Logger.getLogger(ProjectController.class) ;

	@Autowired
	ProjectService projectService;
	
	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getactiveprojects", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getactiveprojects() {
		List<ProjectMapping> teamList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			teamList = projectService.getAllActiveProjects();
			if (teamList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(teamList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error("Active project list is empty.");
			}
		}catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage("Exception Occurred.");
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}
}
