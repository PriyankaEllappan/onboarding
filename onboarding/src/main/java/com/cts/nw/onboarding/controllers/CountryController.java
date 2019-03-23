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

import com.cts.nw.onboarding.bo.CountryMapping;
import com.cts.nw.onboarding.service.CountryService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/country")
public class CountryController extends AbstractController {

	@Autowired
	CountryService countryService;

	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getcountries", method = RequestMethod.GET)
	public @ResponseBody List<CountryMapping> getAllCountryDetails() {
		List<CountryMapping> countryList;
		countryList = countryService.getAllCountryDetails();
		if (countryList.size() > 0) {
			return countryList;
		} else {
			return null;
		}
	}

}
