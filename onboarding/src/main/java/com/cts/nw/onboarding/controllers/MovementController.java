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
import com.cts.nw.onboarding.bo.Movement;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.service.MovementService;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/movement")
public class MovementController extends AbstractController {

	Logger log = Logger.getLogger(MovementController.class) ;
	
	@Autowired
	MovementService movementService;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getmovements", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllMovements() {
		List<Movement> movementList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			movementList = movementService.getMovementDetails();
			if (movementList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(movementList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(ErrorConstants.EMPTY_LIST);
			}
		}catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.ERROR_MSG);
			log.error(e);
		}
		return ajaxResponse;
	}

}
