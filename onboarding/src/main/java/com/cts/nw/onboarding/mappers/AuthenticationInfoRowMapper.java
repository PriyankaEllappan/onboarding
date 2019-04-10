/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bean.AuthenticationInfo;

/**
 * @author 656579
 *
 */
public class AuthenticationInfoRowMapper  implements RowMapper<AuthenticationInfo>  {

	@Override
	public AuthenticationInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		AuthenticationInfo authInfo = new AuthenticationInfo();
		authInfo.setUserName(rs.getString("USERNAME"));
		authInfo.setCurrPassword(rs.getString("PASSWORD"));
		authInfo.setIsEnabled(rs.getInt("ENABLED"));
		return authInfo;
	}

}
