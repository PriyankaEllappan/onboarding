/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.Bands;

/**
 * @author 616550
 *
 */
public class BandsRowMapper implements RowMapper<Bands> {

	@Override
	public Bands mapRow(ResultSet rs, int rowNum) throws SQLException {
		Bands band = new Bands();
		band.setId(rs.getInt("ID"));
		band.setBandName(rs.getString("BANDNAME"));
		return band;
		
	}

}
