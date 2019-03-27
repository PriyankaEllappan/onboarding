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

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.mappers.EmployeeProjHistRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class EmployeeProjHistDAOImpl implements EmployeeProjHistDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* 1. Requester Operations */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getEmployeesPerRequester(
	 * java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getEmployeesPerRequester(String requesterId) {
		try {
			String whereClause = " WHERE RQ.REQUESTERID = ? OR EPH.ONBOARDREQUESTER = ?  ";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper, requesterId, requesterId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cts.nw.onboarding.dao.EmployeeProjHistDAO#checkActiveAssignments(java
	 * .lang.String)
	 */
	@Override
	public List<EmployeeProjHist> checkActiveAssignments(String empid) {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2) AND EMPLOYEEID = ? ORDER BY ID";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper, empid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cts.nw.onboarding.dao.EmployeeProjHistDAO#addEmployeeProjectInfo(com.
	 * cts.nw.onboarding.bo.EmployeeProjHist)
	 */
	@Override
	public Integer addEmployeeProjectInfo(EmployeeProjHist employeeProjectHist) {
		try {
			return jdbcTemplate.update(QueryConstants.EMPPROJECTHIST_INSERT, employeeProjectHist.getId(),
					employeeProjectHist.getEmployeeId(), employeeProjectHist.getProjectMappingId(),
					employeeProjectHist.getTeamId(), employeeProjectHist.getBsaId(), employeeProjectHist.getRoleId(),
					employeeProjectHist.getCountryId(), employeeProjectHist.getStartDate(),
					employeeProjectHist.getMovementId(), employeeProjectHist.getExperience(),
					employeeProjectHist.getSkillSet(), employeeProjectHist.getSkillSummary(),
					employeeProjectHist.getApprovalStatusId(), employeeProjectHist.getReleaseStatusId(),
					employeeProjectHist.getOnboardRequester());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* 2. Processor Operations */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#
	 * getRecordsPerProcessortoOnboard(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOnboard(String processorid) {
		try {
			String whereClause = " WHERE PR.PROCESSORID = ? OR EPH.OFFBOARDPROCESSOR = ? ORDER BY EPH.APPROVALSTATUS";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper, processorid, processorid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#
	 * updateSpecificEmployeeProjectHist(com.cts.nw.onboarding.bo.
	 * EmployeeProjHist)
	 */
	@Override
	public Integer onBoardEmployee(EmployeeProjHist employeeProjectHist) {
		try {
			return jdbcTemplate.update(QueryConstants.ONBOARDPROCESS_UPDATE, employeeProjectHist.getNationwideId(),
					employeeProjectHist.getNationwideIdCreatedDate(), employeeProjectHist.getFgOnBoardingDate(),
					employeeProjectHist.getWorkForceId(), employeeProjectHist.getScrumMaster(),
					employeeProjectHist.getApm(), employeeProjectHist.getPplManager(), employeeProjectHist.getBandId(),
					employeeProjectHist.getAttachmentId(), employeeProjectHist.getComments(),
					employeeProjectHist.getApprovalStatusId(), employeeProjectHist.getId());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#
	 * getRecordsPerProcessortoOffboard(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getRecordsPerProcessortoOffboard(String processorid) {
		try {
			String whereClause = " WHERE ( PR.PROCESSORID = ? OR EPH.OFFBOARDPROCESSOR = ? ) AND EPH.RELEASESTATUS IN (2,3)";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper, processorid, processorid);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Integer processOffboardEmployee(EmployeeProjHist employeeProjectHist, Integer Id) {
		try {
			return jdbcTemplate.update(QueryConstants.PROCESS_OFFBOARD_UPDATE, employeeProjectHist.getReleaseStatusId(),
					Id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* 3. Release Operations */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getEmployeestobeReleased()
	 */
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleased() {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2)";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#
	 * getEmployeestobeReleasedbyTeam(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId) {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2) AND EPH.TEAM = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper, teamId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#
	 * getEmployeestobeReleasedbyProj(java.lang.String)
	 */
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyProj(String projectId) {
		try {
			String whereClause = " WHERE EPH.RELEASESTATUS IN (1,2) AND PM.PROJECTID = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(query, rowMapper, projectId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Integer offboardEmployee(EmployeeProjHist employeeProjectHist, Integer Id) {
		try {
			return jdbcTemplate.update(QueryConstants.REQUEST_OFFBOARD_UPDATE, employeeProjectHist.getReleaseStatusId(),
					employeeProjectHist.getReleaseDate(), employeeProjectHist.getReasonForOffboarding(),
					employeeProjectHist.getOffboardRequester(), employeeProjectHist.getOffboardProcessor(), Id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/* 4. Common Operations */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cts.nw.onboarding.dao.EmployeeProjHistDAO#
	 * getSpecificEmployeeProjectHist(java.lang.String)
	 */
	@Override
	public EmployeeProjHist getSpecificEmployeeProjectHist(String empProjHistId) {
		try {
			String whereClause = " WHERE EPH.ID = ?";
			String query = QueryConstants.EMPPROJHIST_SELECT + whereClause;
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			EmployeeProjHist emp = this.jdbcTemplate.queryForObject(query, rowMapper, empProjHistId);
			System.out.println(emp.toString());
			return emp;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cts.nw.onboarding.dao.EmployeeProjHistDAO#getAllEmployeeProjectInfo()
	 */
	@Override
	public List<EmployeeProjHist> getAllEmployeeProjectInfo() {
		try {
			RowMapper<EmployeeProjHist> rowMapper = new EmployeeProjHistRowMapper();
			return this.jdbcTemplate.query(QueryConstants.EMPPROJHIST_SELECT, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
