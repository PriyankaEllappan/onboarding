package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.Roles;
import com.cts.nw.onboarding.dao.RolesDAO;
import com.cts.nw.onboarding.mappers.RoleRowMapper;
@Transactional
@Repository
public class RolesDAOImpl implements RolesDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Roles> getAllRoles() {
		
		String allRolesInfo = "SELECT * FROM ROLES";
		
		try {
			RowMapper<Roles> rowMapper = new RoleRowMapper();
			return this.jdbcTemplate.query(allRolesInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
