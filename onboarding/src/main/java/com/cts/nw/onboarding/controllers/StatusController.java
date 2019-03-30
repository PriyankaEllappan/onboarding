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
import com.cts.nw.onboarding.bo.ApprovalStatus;
import com.cts.nw.onboarding.bo.ReleaseStatus;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.service.StatusService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/status")
public class StatusController extends AbstractController {

	Logger log = Logger.getLogger(StatusController.class);
	@Autowired
	StatusService statusService;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getallapprovalstatus", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllApprovalStatus() {
		List<ApprovalStatus> statList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			statList = statusService.getAllApprovalStatus();
			if (statList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(statList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(ErrorConstants.APPROVALSTATUSLISTERROR);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.COMMONERROR);
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getallreleasestatus", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllReleaseStatus() {
		List<ReleaseStatus> statList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			statList = statusService.getAllReleaseStatus();
			if (statList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(statList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(ErrorConstants.RELEASESTATUSLISTERROR);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.COMMONERROR);
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}
}
