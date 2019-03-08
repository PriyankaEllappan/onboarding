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
import com.cts.nw.onboarding.dao.CountryMappingDAO;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryMappingDAO countryMappingDAO;
	/**
	 * @param teamname
	 * @return
	 */
	@RequestMapping(value = "/getAllCountryDetails", method = RequestMethod.GET)
	public @ResponseBody List<CountryMapping> getAllCountryDetails() {
		return countryMappingDAO.getAllCountryMapping();
	}
	
}
