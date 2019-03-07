package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.EmployeeProjectInfo;
import com.cts.nw.onboarding.dao.EmployeeProjectInfoDAO;
import com.cts.nw.onboarding.mappers.EmployeeProjectInfoRowMapper;

@Transactional
@Repository
public class EmployeeProjectInfoDAOImpl implements EmployeeProjectInfoDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<EmployeeProjectInfo> getAllEmployeeProjectInfo() {
		   String sql = "SELECT * FROM EmployeeProjectInfo";
		   RowMapper<EmployeeProjectInfo> rowMapper = new EmployeeProjectInfoRowMapper();
		   return this.jdbcTemplate.query(sql, rowMapper);
	}
}
