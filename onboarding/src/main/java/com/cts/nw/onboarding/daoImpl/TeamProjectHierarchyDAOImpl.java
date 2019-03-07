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
		String teamInfo = "SELECT tt.id,pp.projectid, pp.projectname,r.requesterid,r.requestername, p.processorid, p.processorname, b.id,b.bsa, ppi.id,ppi.pplname,t.teamname,pm.status "
				+ "FROM requesters r JOIN projectmapping pm ON r.requesterid = pm.requesterid JOIN "
				+ " processors p ON p.processorid = pm.processorid  JOIN  projectinfo pp ON"
				+ " pp.projectid = pm.projectid  JOIN  teammapping tt ON tt.projectmapid = pm.id  "
				+ "JOIN  pplmapping ppm ON ppm.id = tt.pplmapid JOIN bsainfo b ON ppm.bsaid = b.id "
				+ "JOIN  pplinfo ppi ON ppi.id = ppm.pplid JOIN teams t ON t.id = tt.teamid " + "WHERE t.teamname = ? ";
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
		String teamInfo = "SELECT tt.id,pp.projectid, pp.projectname,r.requesterid,r.requestername, p.processorid, p.processorname, b.id,b.bsa, ppi.id,ppi.pplname,t.teamname,pm.status "
				+ "FROM requesters r JOIN projectmapping pm ON r.requesterid = pm.requesterid JOIN "
				+ " processors p ON p.processorid = pm.processorid  JOIN  projectinfo pp ON"
				+ " pp.projectid = pm.projectid  JOIN  teammapping tt ON tt.projectmapid = pm.id  "
				+ "JOIN  pplmapping ppm ON ppm.id = tt.pplmapid JOIN bsainfo b ON ppm.bsaid = b.id "
				+ "JOIN  pplinfo ppi ON ppi.id = ppm.pplid JOIN teams t ON t.id = tt.teamid ";
		try {
			RowMapper<TeamProjectHierarchy> rowMapper = new TeamProjectHierarchyRowMapper();
			return this.jdbcTemplate.query(teamInfo, rowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
