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

import com.cts.nw.onboarding.bo.CountryMapping;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.CountryMappingDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.mappers.CountryMappingRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class CountryMappingDAOImpl implements CountryMappingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CountryMapping> getAllCountryMapping() throws CustomException {

		try {
			String allCountryInfo = QueryConstants.COUNTRYMAPPING_SELECT;
			RowMapper<CountryMapping> rowMapper = new CountryMappingRowMapper();
			return this.jdbcTemplate.query(allCountryInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e);
		}
	}

}
