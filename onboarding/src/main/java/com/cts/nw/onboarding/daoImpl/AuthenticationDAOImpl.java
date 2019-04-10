/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bean.AuthenticationInfo;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.AuthenticationDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.mappers.AuthenticationInfoRowMapper;

/**
 * @author 656579
 *
 */
@Transactional
@Repository
public class AuthenticationDAOImpl implements AuthenticationDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public AuthenticationInfo getUserDetailsByID(String id) throws CustomException {
		String whereClause = " WHERE U.USERNAME = ? ";
		String query = QueryConstants.USERS_SELECT + whereClause;
		try {
			RowMapper<AuthenticationInfo> rowMapper = new AuthenticationInfoRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper,id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e.getMessage());
		}
	}
	
	@Override
	public Integer updateUserDetails(AuthenticationInfo authenticationInfo) throws CustomException {
		try {
			return jdbcTemplate.update(QueryConstants.USERS_UPDATE,authenticationInfo.getNewPassword(),authenticationInfo.getUserName());
		} catch(Exception e){
			throw new CustomException(e.getMessage());
		}
	}
	
}
