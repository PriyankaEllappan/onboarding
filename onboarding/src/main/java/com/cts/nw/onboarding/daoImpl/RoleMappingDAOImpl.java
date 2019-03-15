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
import com.cts.nw.onboarding.bo.Roles;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.RoleMappingDAO;
import com.cts.nw.onboarding.mappers.RoleMappingRowMapper;
import com.cts.nw.onboarding.mappers.RoleRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class RoleMappingDAOImpl implements RoleMappingDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<RoleMapping> getAllRoleMappingDetails() {
		try {
			RowMapper<RoleMapping> rowMapper = new RoleMappingRowMapper();
			return this.jdbcTemplate.query(QueryConstants.ROLEMAPPING_SELECT, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<Roles> getRoleDetails() {
		try {
			RowMapper<Roles> rowMapper = new RoleRowMapper();
			return this.jdbcTemplate.query(QueryConstants.ROLES_SELECT, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}
