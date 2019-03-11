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

import com.cts.nw.onboarding.bo.EmployeeRelease;
import com.cts.nw.onboarding.dao.EmployeeReleaseDAO;
import com.cts.nw.onboarding.mappers.EmployeeReleaseRowMapper;

/**
 * @author 616550
 *
 */
@Transactional
@Repository
public class EmployeeReleaseDAOImpl implements EmployeeReleaseDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override

	public List<EmployeeRelease> getEmployeeReleaseDetails(int employeeID, String releaseStatus) {

		String employeeReleaseInfo = "SELECT EMPPI.EMPLOYEEID AS EMPLOYEEID ,PM.PROJECTID AS PROJECTID,  "
				+ "PI.PROJECTNAME AS PROJECTNAME,PM.STATUS AS PROJECTSTATUS,  PM.REQUESTERID AS REQUESTERID, "
				+ "R.REQUESTERNAME AS REQUESTERNAME,  PM.PROCESSORID AS PROCESSORID ,P.PROCESSORNAME AS PROCESSORNAME, "
				+ " EMPPI.RELEASEDATE AS RELEASEDATE ,  RS.STATUS AS RELEASESTATUS FROM EMPLOYEEPROJECTINFO EMPPI "
				+ "JOIN RELEASESTATUS RS ON RS.ID = EMPPI.RELEASESTATUS  JOIN TEAMMAPPING TM ON TM.ID=EMPPI.TEAM "
				+ "JOIN PROJECTMAPPING PM ON PM.ID = TM.PROJECTMAPID  JOIN PROJECTINFO PI ON PI.PROJECTID = PM.PROJECTID "
				+ "JOIN REQUESTERS R ON R.REQUESTERID = PM.REQUESTERID "
				+ " JOIN PROCESSORS P ON P.PROCESSORID =PM.PROCESSORID  "
				+ "WHERE EMPPI.EMPLOYEEID = ? AND RS.STATUS = ? ";
		try {
			RowMapper<EmployeeRelease> rowMapper = new EmployeeReleaseRowMapper();
			return this.jdbcTemplate.query(employeeReleaseInfo, rowMapper,employeeID,releaseStatus);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
