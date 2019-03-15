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

import com.cts.nw.onboarding.bo.Bands;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.BandsDAO;
import com.cts.nw.onboarding.mappers.BandsRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository


public class BandDAOImpl implements BandsDAO{

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Bands> getAllBandDetails() {
		try {
			RowMapper<Bands> rowMapper = new BandsRowMapper();
			return this.jdbcTemplate.query(QueryConstants.BANDS_SELECT,rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
