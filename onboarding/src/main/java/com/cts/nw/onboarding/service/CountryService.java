/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.CountryMapping;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface CountryService {

	List<CountryMapping> getAllCountryDetails() throws CustomException;
}
