/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.CountryMapping;
import com.cts.nw.onboarding.dao.CountryMappingDAO;
import com.cts.nw.onboarding.service.CountryService;

/**
 * @author 656579
 *
 */
@Service
public class CountryServiceImpl  implements CountryService {
	@Autowired
	CountryMappingDAO countryMappingDAO;

	@Override
	public List<CountryMapping> getAllCountryDetails() {
		return countryMappingDAO.getAllCountryMapping();
	}
	

}
