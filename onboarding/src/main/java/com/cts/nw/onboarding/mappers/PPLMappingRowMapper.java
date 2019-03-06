package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.PPLMapping;

public class PPLMappingRowMapper implements RowMapper<PPLMapping>{

	@Override
	public PPLMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
		PPLMapping pplMapping = new PPLMapping();
		pplMapping.setBsaID(rs.getInt("BSAID"));
		pplMapping.setPplID(rs.getInt("PPLID"));
		pplMapping.setId(rs.getInt("ID"));
		return pplMapping;
	}

}


