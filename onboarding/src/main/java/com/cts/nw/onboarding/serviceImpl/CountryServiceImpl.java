/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
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
	
	Logger log = Logger.getLogger(CountryServiceImpl.class) ;
	@Autowired
	CountryMappingDAO countryMappingDAO;

	@Override
	public List<CountryMapping> getAllCountryDetails() {
		try {
			return countryMappingDAO.getAllCountryMapping();
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}
	

}
