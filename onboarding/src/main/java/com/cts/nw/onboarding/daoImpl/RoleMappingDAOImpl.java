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

import com.cts.nw.onboarding.bo.RoleMapping;
import com.cts.nw.onboarding.dao.RoleMappingDAO;
import com.cts.nw.onboarding.mappers.RoleMappingRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class RoleMappingDAOImpl  implements RoleMappingDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<RoleMapping> getAllRoleMappingDetails() {
		
		String allRatesInfo = "SELECT RM.ID AS ROLEMAPPINGID,RT.RATE AS RATEVALUE,"
				+ "RM.ROLEID  AS ROLEID ,RM.COUNTRYMAPPINGID AS COUNTRYMAPPINGID "
				+ "FROM ROLEMAPPING RM JOIN RATES RT ON RT.ID = RM.RATEID ";
		
		try {
			RowMapper<RoleMapping> rowMapper = new RoleMappingRowMapper();
			return this.jdbcTemplate.query(allRatesInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
