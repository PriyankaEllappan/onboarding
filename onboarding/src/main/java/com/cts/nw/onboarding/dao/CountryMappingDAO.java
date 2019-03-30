/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.CountryMapping;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface CountryMappingDAO {
	
	public List<CountryMapping> getAllCountryMapping() throws CustomException;
}
