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

import com.cts.nw.onboarding.bo.BSA;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.BSADAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.mappers.BSARowMapper;

/**
 * @author 656579
 *
 */
@Transactional
@Repository
public class BSADAOImpl implements BSADAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<BSA> getActiveBsaDetails() throws CustomException {
		try {
			RowMapper<BSA> rowMapper = new BSARowMapper();
			return this.jdbcTemplate.query(QueryConstants.BSA_SELECT,rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e);
		}
	}

}
