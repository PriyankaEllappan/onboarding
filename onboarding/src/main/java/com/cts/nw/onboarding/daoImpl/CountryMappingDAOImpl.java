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
import com.cts.nw.onboarding.dao.CountryMappingDAO;
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

	public List<CountryMapping> getAllCountryMapping() {
		String allCountryInfo = "SELECT CT.COUNTRY AS COUNTRYNAME,LI.LOCATION AS LOCATIONNAME ,"
				+ "CTM.ID AS COUNTRYMAPPINGID " + "FROM COUNTRYMAPPING CTM " + "JOIN COUNTRIES CT ON "
				+ "CTM.COUNTRYID =CT.ID JOIN LOCATIONS LI ON CTM.LOCATIONID = LI.ID";
		try {
			RowMapper<CountryMapping> rowMapper = new CountryMappingRowMapper();
			return this.jdbcTemplate.query(allCountryInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
