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

import com.cts.nw.onboarding.bo.ApprovalStatus;
import com.cts.nw.onboarding.bo.ReleaseStatus;
import com.cts.nw.onboarding.service.StatusService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	StatusService statusService;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getallapprovalstatus", method = RequestMethod.GET)
	public @ResponseBody List<ApprovalStatus> getAllApprovalStatus() {
		List<ApprovalStatus> statList = null;
		try {
			statList = statusService.getAllApprovalStatus();
			if (statList.size() > 0) {
				return statList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getallreleasestatus", method = RequestMethod.GET)
	public @ResponseBody List<ReleaseStatus> getAllReleaseStatus() {
		List<ReleaseStatus> statList = null;
		try {
			statList = statusService.getAllReleaseStatus();
			if (statList.size() > 0) {
				return statList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
