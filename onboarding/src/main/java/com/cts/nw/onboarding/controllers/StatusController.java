/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.ApprovalStatus;
import com.cts.nw.onboarding.bo.ReleaseStatus;
import com.cts.nw.onboarding.dao.ApprovalStatusDAO;
import com.cts.nw.onboarding.dao.ReleaseStatusDAO;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	ApprovalStatusDAO approvalStatusDAO;
	
	@Autowired
	ReleaseStatusDAO releaseStatusDAO;
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getapprovalid/{status}", method = RequestMethod.GET)
	public @ResponseBody ApprovalStatus getApprovalStatusId(@PathVariable String status) {
		ApprovalStatus stat = null;
		try {
			System.out.println(approvalStatusDAO.getApprovalStatusID(status));
			return approvalStatusDAO.getApprovalStatusID(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stat;
	}
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getreleaseid/{status}", method = RequestMethod.GET)
	public @ResponseBody ReleaseStatus getReleaseStatusID(@PathVariable String status) {
		ReleaseStatus stat = null;
		try {
			System.out.println(releaseStatusDAO.getReleaseStatusID(status));
			return releaseStatusDAO.getReleaseStatusID(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stat;
	}
}
