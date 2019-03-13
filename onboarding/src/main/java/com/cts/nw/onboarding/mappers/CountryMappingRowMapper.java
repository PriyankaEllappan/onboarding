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
public class CountryMappingRowMapper extends AbstractRowMapper implements RowMapper<CountryMapping> {

	@Override
	public CountryMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		CountryMapping countryMapping = new CountryMapping();
		if (hasColumn(rs, "COUNTRYNAME") == true) {
		countryMapping.setCountryName(rs.getString("COUNTRYNAME"));
		}
		if (hasColumn(rs, "LOCATIONNAME") == true) {
		countryMapping.setLocationName(rs.getString("LOCATIONNAME"));
		}
		if (hasColumn(rs, "COUNTRYMAPPINGID") == true) {
		countryMapping.setCountryMappingID(rs.getInt("COUNTRYMAPPINGID"));
		}
		return countryMapping;
	}

}
