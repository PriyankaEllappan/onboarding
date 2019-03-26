/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.BSA;

/**
 * @author 656579
 *
 */
public class BSARowMapper implements RowMapper<BSA> {

	@Override
	public BSA mapRow(ResultSet rs, int rowNum) throws SQLException {
		BSA bsa = new BSA();
		bsa.setBsaId(rs.getString("ID"));
		bsa.setBsaName(rs.getString("BSANAME"));
		return bsa;
	}
}
