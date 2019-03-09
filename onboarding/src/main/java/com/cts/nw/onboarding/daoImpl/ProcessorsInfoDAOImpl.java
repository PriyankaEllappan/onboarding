package com.cts.nw.onboarding.daoImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.ProcessorsInfo;
import com.cts.nw.onboarding.dao.ProcessorsInfoDAO;
import com.cts.nw.onboarding.mappers.ProcessorsInfoRowMapper;

@Transactional
@Repository
public class ProcessorsInfoDAOImpl implements ProcessorsInfoDAO{
	
	private String queryApprovalStatusParam1 = "NEW"; //'NEW'
	private String queryApprovalStatusParam2 = "INPROGRESS"; //'INPROGRESS'
	String processorQuery = "SELECT EMPPI.ID AS ID, EMPPI.EMPLOYEEID AS EMPLOYEEID, EM.NAME AS NAME, "
			+ "EM.FIRSTNAME AS FIRSTNAME, EM.LASTNAME AS LASTNAME, "
			+ "EM.DOB AS DOB, EM.PASSPORTNUMBER AS PASSPORTNUMBER, "
			+ "EM.EMAIL AS EMAIL, EMPPI.STARTDATE AS STARTDATE, "
			+ "EMPPI.RELEASESTATUS AS RELEASESTATUS, EMPPI.NATIOWIDEID AS NATIOWIDEID, EMPPI.NATIONWIDEIDCREATEDDATE AS NATIONWIDEIDCREATEDDATE, "
			+ "EMPPI.FGONBOARDINGDATE AS FGONBOARDINGDATE, EMPPI.SKILLSET, EMPPI.COMMENTS, "
			+ "EMPPI.SKILLSUMMARY AS SKILLSUMMARY, "
			+ "EMPPI.APPROVALSTATUS AS APPROVALSTATUS, PI.PROJECTNAME AS PROJECTNAME,PI.PROJECTID  AS PROJECTID, P.PROCESSORID AS PROCESSORID, "
			+ "P.PROCESSORNAME AS PROCESSORNAME, R.REQUESTERID AS REQUESTERID, "
			+ "R.REQUESTERNAME AS REQUESTERNAME, T.TEAMNAME AS TEAMNAME, "
			+ "RO.ROLE AS ROLENAME, RT.RATE AS RATENAME, CT.COUNTRY AS COUNTRYNAME, "
			+ "LO.LOCATION AS LOCATIONNAME, BI.BSA AS BSANAME, PPLI.PPLNAME AS PPLNAME FROM "
			+ "EMPLOYEEPROJECTINFO EMPPI JOIN EMPLOYEEMASTER EM ON EM.ID = EMPPI.EMPLOYEEID JOIN "
			+ "APPROVALSTATUS APS ON EMPPI.APPROVALSTATUS = APS.ID JOIN TEAMMAPPING TM ON TM.ID = EMPPI.TEAM "
			+ "JOIN PROJECTMAPPING PM ON PM.ID = TM.PROJECTMAPID JOIN PROJECTINFO PI ON PI.PROJECTID = PM.PROJECTID JOIN PROCESSORS P ON PM.PROCESSORID = P.PROCESSORID "
			+ "JOIN REQUESTERS R ON R.REQUESTERID = PM.REQUESTERID JOIN ROLEMAPPING RM ON EMPPI.ROLE = RM.ID "
			+ "JOIN TEAMS T ON T.ID = TM.TEAMID JOIN ROLES RO ON RO.ID = RM.ROLEID JOIN "
			+ "RATES RT ON RT.ID = RM.RATEID JOIN COUNTRYMAPPING CTM ON CTM.ID = EMPPI.COUNTRY "
			+ "JOIN COUNTRIES CT ON CT.ID = CTM.COUNTRYID JOIN LOCATIONS LO ON LO.ID = CTM.LOCATIONID "
			+ "JOIN PPLMAPPING PPLM ON PPLM.ID = TM.PPLMAPID JOIN BSAINFO BI ON PPLM.BSAID = BI.ID JOIN PPLINFO "
			+ "PPLI ON PPLI.ID = PPLM.PPLID";
	String getRecordsPerProcessorSQL = processorQuery + " WHERE P.PROCESSORID = ? AND APS.STATUS IN (?,?)";
	String getEmployeeToProcessSQL =  processorQuery + " WHERE P.PROCESSORID = ? AND APS.STATUS IN (?,?) AND EMPPI.ID =?";
	String getReleasedEmployeesSQL = processorQuery + " WHERE EMPPI.RELEASESTATUS=?";
	String getEmployeetoReleasebyID = processorQuery + " WHERE EMPPI.ID=?";
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public ProcessorsInfo getEmployeeToProcess(int processorid, int employeeProjectInfoID) {
		try {
			RowMapper<ProcessorsInfo> rowMapper = new ProcessorsInfoRowMapper();
			return this.jdbcTemplate.queryForObject(getEmployeeToProcessSQL, rowMapper, processorid, queryApprovalStatusParam1, queryApprovalStatusParam2, employeeProjectInfoID);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	@Override
	public List<ProcessorsInfo> getRecordsPerProcessor(int processorid) {
		try {
			RowMapper<ProcessorsInfo> rowMapper = new ProcessorsInfoRowMapper();
			return this.jdbcTemplate.query(getRecordsPerProcessorSQL, rowMapper, processorid, queryApprovalStatusParam1, queryApprovalStatusParam2);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	@Override
	public List<ProcessorsInfo> getEmployeesbyReleaseStatusId(int releaseStatusID) {
		try {
			RowMapper<ProcessorsInfo> rowMapper = new ProcessorsInfoRowMapper();
			return this.jdbcTemplate.query(getReleasedEmployeesSQL, rowMapper, releaseStatusID);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public ProcessorsInfo getEmployeestoReleasebyId(int empProjInfoId) {
		try {
			RowMapper<ProcessorsInfo> rowMapper = new ProcessorsInfoRowMapper();
			return this.jdbcTemplate.queryForObject(getEmployeetoReleasebyID, rowMapper, empProjInfoId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Integer processAnEmployee(ProcessorsInfo employeeProjJson) {
		return null;
	/*	String sql = "INSERT INTO EmployeeMaster (ID, NAME, FIRSTNAME, LASTNAME, DOB, PASSPORTNUMBER,EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, employeeMaster.getID(), employeeMaster.getName(), employeeMaster.getFirstName(),
				employeeMaster.getLastName(), employeeMaster.getDOB(), employeeMaster.getPassportNumber(), employeeMaster.getEmail());*/
	}

	@Override
	public Integer releaseAnEmployee(ProcessorsInfo employeeProjJson) {
		// TODO Auto-generated method stub
		return null;
	}

}