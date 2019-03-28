/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.dao.TeamsDAO;
import com.cts.nw.onboarding.service.TeamService;

/**
 * @author 656579
 *
 */
@Service
public class TeamServiceImpl implements TeamService{
	
	Logger log = Logger.getLogger(TeamServiceImpl.class) ;

	@Autowired
	TeamsDAO teamsDAO; 
	
	@Override
	public List<Teams> getAllTeams() {
		try {
			return teamsDAO.getAllActiveTeams();
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

}
