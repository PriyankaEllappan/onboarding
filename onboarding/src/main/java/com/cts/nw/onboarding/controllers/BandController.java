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
import com.cts.nw.onboarding.bo.Bands;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.service.BandService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/band")
public class BandController extends AbstractController {

	Logger log = Logger.getLogger(BandController.class) ;
	
	@Autowired
	BandService bandService;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getbands", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllBands() {
		List<Bands> bandList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			bandList = bandService.getBandDetails();
			if (bandList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(bandList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error("Bands list is empty");
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage("Exception Occurred.");
			log.error(e.getMessage());
		}
		return ajaxResponse;
	}
}
