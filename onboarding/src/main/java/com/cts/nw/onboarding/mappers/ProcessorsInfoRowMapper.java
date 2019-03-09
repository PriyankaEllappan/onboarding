package com.cts.nw.onboarding.mappers;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.ProcessorsInfo;

public class ProcessorsInfoRowMapper implements RowMapper<ProcessorsInfo>{

	@Override
	public ProcessorsInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProcessorsInfo processorsInfo = new ProcessorsInfo();

		processorsInfo.setId(rs.getInt("ID"));	//EMPPI.ID AS ID
		processorsInfo.setEmployeeMasterID(rs.getInt("EMPLOYEEID")); //EM.ID AS EMPLOYEEID, 
		processorsInfo.setName(rs.getString("NAME")); //EM.NAME AS NAME,
		processorsInfo.setFirstName(rs.getString("FIRSTNAME"));//EM.FIRSTNAME AS FIRSTNAME,
		processorsInfo.setLastName(rs.getString("LASTNAME"));//EM.LASTNAME AS LASTNAME,
		processorsInfo.setDOB(rs.getDate("DOB"));//EM.DOB AS DOB,
		processorsInfo.setPassportNumber(rs.getString("PASSPORTNUMBER"));//EM.PASSPORTNUMBER AS PASSPORTNUMBER, 
		processorsInfo.setEmail(rs.getString("EMAIL"));//EM.EMAIL AS EMAIL, 
		processorsInfo.setStartDate(rs.getDate("STARTDATE"));//EMPPI.STARTDATE AS STARTDATE,
		processorsInfo.setNatiowideID(rs.getString("NATIOWIDEID"));;//EMPPI.NATIOWIDEID AS NATIOWIDEID,
		processorsInfo.setNationwideidCreatedDate(rs.getDate("NATIONWIDEIDCREATEDDATE"));;//EMPPI.NATIONWIDEIDCREATEDDATE AS NATIONWIDEIDCREATEDDATE,
		processorsInfo.setFgOnboardingDate(rs.getDate("FGONBOARDINGDATE"));//EMPPI.FGONBOARDINGDATE AS FGONBOARDINGDATE,
		processorsInfo.setSkillSet(rs.getString("SKILLSET"));//EMPPI.SKILLSET AS SKILLSET, //need to add in query
		processorsInfo.setComments(rs.getString("COMMENTS"));//EMPPI.COMMENTS AS COMMENTS, //need to add in query
		processorsInfo.setSkillSummary(rs.getString("SKILLSUMMARY"));//EMPPI.SKILLSUMMARY AS SKILLSUMMARY,
		processorsInfo.setReleaseStatus(rs.getInt("RELEASESTATUS"));
		processorsInfo.setProjectName(rs.getString("PROJECTNAME"));//PI.PROJECTNAME AS PROJECTNAME,
		processorsInfo.setProjectId(rs.getString("PROJECTID"));//PI.PROJECTNAME AS PROJECTID,
		processorsInfo.setRequesterID(rs.getInt("REQUESTERID"));//R.REQUESTERID AS REQUESTERID,
		processorsInfo.setRequesterName(rs.getString("REQUESTERNAME"));//R.REQUESTERNAME AS REQUESTERNAME,
		processorsInfo.setProcessorID(rs.getInt("PROCESSORID"));//P.PROCESSORID AS PROCESSORID,
		processorsInfo.setProcessorName(rs.getString("PROCESSORNAME"));//P.PROCESSORNAME AS PROCESSORNAME,
		processorsInfo.setTeamName(rs.getString("TEAMNAME"));//T.TEAMNAME AS TEAMNAME,
		processorsInfo.setBsaInfo(rs.getString("BSANAME"));//BI.BSA AS BSANAME,
		processorsInfo.setPplInfo(rs.getString("PPLNAME"));//PPLI.PPLNAME AS PPLNAME,
		processorsInfo.setApprovalStatus(rs.getInt("APPROVALSTATUS"));//EMPPI.APPROVALSTATUS AS APPROVALSTATUS, private Integer approvalStatus;
		processorsInfo.setCountryName(rs.getString("COUNTRYNAME"));//CT.COUNTRY AS COUNTRYNAME, private String countryName;
		processorsInfo.setLocationName(rs.getString("LOCATIONNAME"));//LO.LOCATION AS LOCATIONNAME, private String locationName;
		processorsInfo.setRoleName(rs.getString("ROLENAME"));//RO.ROLE AS ROLENAME,  private String roleName;
		processorsInfo.setRateValue(rs.getString("RATENAME"));//RT.RATE AS RATENAME,
		return processorsInfo;
	}
}