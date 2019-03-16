/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.Teams;

/**
 * @author 616550
 *
 */
public interface TeamsDAO {

	List<Teams> getAllActiveTeams();
	Integer insertNewTeam(Teams team);
	Integer insertNewViaCallable(Teams team);
}
