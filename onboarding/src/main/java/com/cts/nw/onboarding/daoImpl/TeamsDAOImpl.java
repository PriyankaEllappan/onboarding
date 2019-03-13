/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.TeamsDAO;
import com.cts.nw.onboarding.mappers.TeamsRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class TeamsDAOImpl implements TeamsDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Teams> getAllActiveTeams() {
		try {
			RowMapper<Teams> rowMapper = new TeamsRowMapper();
			return this.jdbcTemplate.query(QueryConstants.TEAMS_SELECT,rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public int insertNewTeam(Teams team) {
		return jdbcTemplate.update(QueryConstants.TEAMS_INSERT,team.getId(),team.getTeamName(),team.getProjMapId(),team.getStatus());
	}

}
