package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.mappers.EmployeeMasterRowMapper;

@Transactional
@Repository
public class EmployeeMasterDAOImpl implements EmployeeMasterDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeMaster getEmployeeMasterDetailsByID(int id) {
		String sql = "SELECT * FROM EmployeeMaster where ID = ?";
		try {
			RowMapper<EmployeeMaster> rowMapper = new EmployeeMasterRowMapper();
			return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<EmployeeMaster> getAllEmployeeMasterDetails() {
		String sql = "SELECT * FROM EmployeeMaster";
		try {
			RowMapper<EmployeeMaster> rowMapper = new EmployeeMasterRowMapper();
			return this.jdbcTemplate.query(sql, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public int addEmployeeMaster(EmployeeMaster employeeMaster) {
		String sql = "INSERT INTO EmployeeMaster (ID, NAME, FIRSTNAME, LASTNAME, DOB, PASSPORTNUMBER,EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, employeeMaster.getID(), employeeMaster.getName(), employeeMaster.getFirstName(),
				employeeMaster.getLastName(), employeeMaster.getDOB(), employeeMaster.getPassportNumber(), employeeMaster.getEmail());
	}

}