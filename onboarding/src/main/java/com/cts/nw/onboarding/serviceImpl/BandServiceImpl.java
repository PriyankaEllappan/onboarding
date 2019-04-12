/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.Bands;
import com.cts.nw.onboarding.dao.BandsDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.BandService;

/**
 * @author 656579
 *
 */
@Service
public class BandServiceImpl implements BandService{
	
	@Autowired
	BandsDAO bandsDAO;

	@Override
	public List<Bands> getBandDetails() throws CustomException {
		try {
			return bandsDAO.getAllBandDetails();
		} catch(Exception e){
			throw new CustomException(e);
		}
	}
}
