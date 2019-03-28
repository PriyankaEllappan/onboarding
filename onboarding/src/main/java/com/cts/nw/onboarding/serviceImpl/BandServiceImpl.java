/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.Bands;
import com.cts.nw.onboarding.dao.BandsDAO;
import com.cts.nw.onboarding.service.BandService;

/**
 * @author 656579
 *
 */
@Service
public class BandServiceImpl implements BandService{

	Logger log = Logger.getLogger(BandServiceImpl.class) ;
	
	@Autowired
	BandsDAO bandsDAO;

	@Override
	public List<Bands> getBandDetails() {
		try {
			return bandsDAO.getAllBandDetails();
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}
}
