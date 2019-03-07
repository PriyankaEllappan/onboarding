package com.cts.nw.onboarding.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.TeamProjectHierarchy;
import com.cts.nw.onboarding.dao.TeamProjectHierarchyDAO;
import com.cts.nw.onboarding.mappers.TeamProjectHierarchyRowMapper;

@Transactional
@Repository
public class TeamProjectHierarchyDAOImpl implements TeamProjectHierarchyDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.TeamProjectHierarchyDAO#getSelectedTeamDetails(java.lang.String)
	 */
	@Override
	public List<TeamProjectHierarchy> getSelectedTeamDetails(String teamName) {
		
		String teamInfo = "select pi.projectid as projectid, pi.projectname as projectname, r.requesterid as requesterid, r.requestername as requestername, p.processorid as processorid,"
				+ " p.processorname as processorname, bi.id as bsaid, bi.bsa as bsaname, ppli.id as pplid, ppli.pplname as pplname, t.teamname as teamname, pm.status as status, tm.id as teammapid from"
				+ " requesters r join projectmapping pm on r.requesterid = pm.requesterid join processors p on p.processorid = pm.processorid join projectinfo pi on pi.projectid = pm.projectid join "
				+ " teammapping tm on tm.projectmapid = pm.id join pplmapping pplm on pplm.id = tm.pplmapid join bsainfo bi on pplm.bsaid = bi.id join pplinfo ppli on ppli.id = pplm.pplid join teams t on t.id = tm.teamid"
				+ " where t.teamname = ? and tm.status='active' ";
		try {
			RowMapper<TeamProjectHierarchy> rowMapper = new TeamProjectHierarchyRowMapper();
			return this.jdbcTemplate.query(teamInfo, rowMapper, teamName);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see com.cts.nw.onboarding.dao.TeamProjectHierarchyDAO#getAllTeamDetails()
	 */
	@Override
	public List<TeamProjectHierarchy> getAllTeamDetails() {
		
		String allTeamsInfo = "select pi.projectid as projectid, pi.projectname as projectname, r.requesterid as requesterid, r.requestername as requestername, p.processorid as processorid,"
				+ " p.processorname as processorname, bi.id as bsaid, bi.bsa as bsaname, ppli.id as pplid, ppli.pplname as pplname, t.teamname as teamname, pm.status as status, tm.id as teammapid from"
				+ " requesters r join projectmapping pm on r.requesterid = pm.requesterid join processors p on p.processorid = pm.processorid join projectinfo pi on pi.projectid = pm.projectid join "
				+ " teammapping tm on tm.projectmapid = pm.id join pplmapping pplm on pplm.id = tm.pplmapid join bsainfo bi on pplm.bsaid = bi.id join pplinfo ppli on ppli.id = pplm.pplid join teams t on t.id = tm.teamid"
				+ " where tm.status='active' ";
		
		try {
			RowMapper<TeamProjectHierarchy> rowMapper = new TeamProjectHierarchyRowMapper();
			return this.jdbcTemplate.query(allTeamsInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
