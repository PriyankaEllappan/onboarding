/*package com.cts.nw.onboarding.daoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.TeamMapping;
import com.cts.nw.onboarding.dao.TeamMappingDAO;
import com.cts.nw.onboarding.mappers.TeamMappingRowMapper;



@Transactional
@Repository
public class TeamMappingDAOImpl implements TeamMappingDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public TeamMapping getAllTeamMappingByID(int id) {
		   String sql = "SELECT * FROM TEAMMAPPING where ID = ?";
		   RowMapper<TeamMapping> rowMapper = new TeamMappingRowMapper();
		   return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}



}*/