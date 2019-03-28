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

import com.cts.nw.onboarding.bo.ProjectMapping;
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
	public @ResponseBody List<ProjectMapping> getactiveprojects() {
		List<ProjectMapping> teamList = null;
		try {
			teamList = projectService.getAllActiveProjects();
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
}
