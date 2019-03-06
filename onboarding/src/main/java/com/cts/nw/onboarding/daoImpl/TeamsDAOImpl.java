/*package com.cts.nw.onboarding.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.dao.TeamsDAO;
import com.cts.nw.onboarding.mappers.TeamsRowMapper;

@Transactional
@Repository
public class TeamsDAOImpl implements TeamsDAO {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public Teams getAllTeamsByID(int id) {
		   String sql = "SELECT * FROM teams where ID = ?";
		   RowMapper<Teams> rowMapper = new TeamsRowMapper();
		   return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	
	@Override
	public Teams getAllTeamsByTeamName(String teamName) {
		   String sql = "SELECT * FROM teams where TEAMNAME = ?";
		   RowMapper<Teams> rowMapper = new TeamsRowMapper();
		   return this.jdbcTemplate.queryForObject(sql, rowMapper, teamName);
	}

}
*/