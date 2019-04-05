/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import java.sql.CallableStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bean.User;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.AdminDAO;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class AdminDAOImpl implements AdminDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void registerUser(User user) throws CustomException {
		try {
			CallableStatement cstmt = jdbcTemplate.getDataSource().getConnection()
					.prepareCall(QueryConstants.ADMINPROCEDURE_REGISTERUSER_INSERT);
			cstmt.setInt(1, user.getEmpID());
			cstmt.setString(2, user.getRole());
			cstmt.execute();
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

}
