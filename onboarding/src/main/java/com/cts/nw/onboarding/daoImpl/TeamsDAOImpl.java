/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
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
import com.cts.nw.onboarding.exception.GlobalExceptionHandler;
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
			String whereClause = " WHERE  T.STATUS = 'ACTIVE'";
			String query = QueryConstants.TEAMS_SELECT + whereClause;
			RowMapper<Teams> rowMapper = new TeamsRowMapper();
			return this.jdbcTemplate.query(query,rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public Integer insertNewViaCallable(Teams team) {
		Integer returnValue = null;
		try {
			CallableStatement cstmt = jdbcTemplate.getDataSource().getConnection().prepareCall(QueryConstants.TEAMPROCEDURE_INSERT);
			cstmt.setString(2, team.getTeamName());
			cstmt.setLong(3, team.getProjMapId());
			cstmt.setString(4, team.getStatus());
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			returnValue = cstmt.getInt(1);
		} catch (SQLException e) {
			new GlobalExceptionHandler().handleSQLException(e);
		}
		return returnValue;
	}
	
}
