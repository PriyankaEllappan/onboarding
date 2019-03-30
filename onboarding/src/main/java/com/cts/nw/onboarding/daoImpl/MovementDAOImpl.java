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

import com.cts.nw.onboarding.bo.Movement;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.MovementDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.mappers.MovementRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository


public class MovementDAOImpl implements MovementDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Movement> getMovementDetails() throws CustomException {
		try {
			RowMapper<Movement> rowMapper = new MovementRowMapper();
			return this.jdbcTemplate.query(QueryConstants.MOVEMENTS_SELECT,rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e.getMessage());
		}
	}

	
}
