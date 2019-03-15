/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.Movement;
import com.cts.nw.onboarding.dao.MovementDAO;
import com.cts.nw.onboarding.service.MovementService;

/**
 * @author 616550
 *
 */
@Service
public class MovementServiceImpl implements MovementService{

	@Autowired
	MovementDAO movementDAO;

	@Override
	public List<Movement> getMovementDetails() {
		return movementDAO.getMovementDetails();
	}
}
