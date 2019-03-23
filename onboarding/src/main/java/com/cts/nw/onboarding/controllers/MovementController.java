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

import com.cts.nw.onboarding.bo.Movement;
import com.cts.nw.onboarding.service.MovementService;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/movement")
public class MovementController extends AbstractController {

	@Autowired
	MovementService movementService;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getmovements", method = RequestMethod.GET)
	public @ResponseBody List<Movement> getAllMovements() {
		List<Movement> movementList = null;
		movementList = movementService.getMovementDetails();
		if (movementList.size() > 0) {
			return movementList;
		} else {
			return null;
		}

	}

}
