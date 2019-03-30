/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.BSA;
import com.cts.nw.onboarding.dao.BSADAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.BSAService;

/**
 * @author 656579
 *
 */
@Service
public class BSAServiceImpl implements BSAService{
	

	@Autowired
	BSADAO bsaDao;
	
	@Override
	public List<BSA> getActiveBsaDetails() throws CustomException {
		try {
			return bsaDao.getActiveBsaDetails();
		} catch(Exception e){
			throw new CustomException(e.getMessage());
		}
	}

}
