package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ReleaseSummary;

/**
 * @author 656579
 *
 */
public interface ReleaseService {

	List<EmployeeProjHist> getEmployeestobeReleased();

	EmployeeProjHist getEmployeetoRelease(String empProjHistId);

	EmployeeProjHist releaseAnEmployee(EmployeeProjHist employeeProjHist);

	List<ReleaseSummary> getAllReleaseSummary();

	List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId);

	List<EmployeeProjHist> getEmployeestobeReleasedbyProject(String projectId);

}
