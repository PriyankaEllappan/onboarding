package com.cts.nw.onboarding.dao;

import com.cts.nw.onboarding.bo.Teams;

public interface TeamsDAO {
	Teams getAllTeamsByID(int id);
	Teams getAllTeamsByTeamName(String teamName) ;
}