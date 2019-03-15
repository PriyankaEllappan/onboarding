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

import com.cts.nw.onboarding.bo.Bands;
import com.cts.nw.onboarding.service.BandService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/band")
public class BandController {

	@Autowired
	BandService bandService;
	
	/**
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getbands", method = RequestMethod.GET)
	public @ResponseBody List<Bands> getAllBands() {
		List<Bands> bandList = null;
		try {
			bandList = bandService.getBandDetails();
			if (bandList.size() > 0) {
				return bandList;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
