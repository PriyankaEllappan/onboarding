package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.TeamProjectHierarchy;

public interface TeamProjectHierarchyDAO {

	List<TeamProjectHierarchy> getSelectedTeamDetails(String teamName);
	List<TeamProjectHierarchy> getAllTeamDetails();
}
