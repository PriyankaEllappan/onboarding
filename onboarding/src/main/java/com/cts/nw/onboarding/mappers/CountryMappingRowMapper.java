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
		/*if (hasColumn(rs, "COUNTRY") == true) {
		countryMapping.setCountryName(rs.getString("COUNTRY"));
		}
		if (hasColumn(rs, "LOCATION") == true) {
		countryMapping.setLocationName(rs.getString("LOCATION"));
		}
		if (hasColumn(rs, "COUNTRYMAPID") == true) {
		countryMapping.setCountryMappingID(rs.getInt("COUNTRYMAPID"));
		}*/
		countryMapping.setCountryName(rs.getString("COUNTRY"));
		countryMapping.setLocationName(rs.getString("LOCATION"));
		countryMapping.setCountryMappingID(rs.getInt("COUNTRYMAPID"));
		return countryMapping;
	}

}
