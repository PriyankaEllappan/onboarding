/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.CountryMapping;

/**
 * @author 616550
 *
 */
public class CountryMappingRowMapper implements RowMapper<CountryMapping>{
	
	@Override
	public CountryMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		CountryMapping countryMapping = new CountryMapping();
		countryMapping.setCountryName(rs.getString("COUNTRYNAME"));
		countryMapping.setLocationName(rs.getString("LOCATIONNAME"));
		countryMapping.setCountryMappingID(rs.getInt("COUNTRYMAPPINGID"));
		return countryMapping;
	}

}
