/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface TeamsDAO {

	List<Teams> getAllActiveTeams() throws CustomException;
	Integer insertNewViaCallable(Teams team) throws CustomException;
}
