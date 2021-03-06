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
import com.cts.nw.onboarding.bo.CountryMapping;
import com.cts.nw.onboarding.constants.AppConstants;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.service.CountryService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/country")
public class CountryController extends AbstractController {

	Logger log = Logger.getLogger(CountryController.class) ;
	
	@Autowired
	CountryService countryService;

	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getcountries", method = RequestMethod.GET)
	public @ResponseBody AjaxResponse getAllCountryDetails() {
		List<CountryMapping> countryList = null;
		AjaxResponse ajaxResponse = new AjaxResponse();
		try {
			countryList = countryService.getAllCountryDetails();
			if (countryList.size() > 0) {
				ajaxResponse.setStatus(AppConstants.AJAXSUCCESS);
				List<Object> objectList = new ArrayList<Object>(countryList);
				ajaxResponse.setResponseList(objectList);
			} else {
				ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
				log.error(ErrorConstants.EMPTY_LIST);
			}
		} catch (Exception e) {
			ajaxResponse.setStatus(AppConstants.AJAXFAILURE);
			ajaxResponse.setStatusMessage(ErrorConstants.ERROR_MSG);
			log.error(e);
		}
		return ajaxResponse;
	}
}
