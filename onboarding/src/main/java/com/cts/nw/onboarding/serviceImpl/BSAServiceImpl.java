/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.BSA;
import com.cts.nw.onboarding.dao.BSADAO;
import com.cts.nw.onboarding.service.BSAService;

/**
 * @author 656579
 *
 */
@Service
public class BSAServiceImpl implements BSAService{
	
	Logger log = Logger.getLogger(BSAServiceImpl.class) ;

	@Autowired
	BSADAO bsaDao;
	
	@Override
	public List<BSA> getActiveBsaDetails() {
		try {
			return bsaDao.getActiveBsaDetails();
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

}
