/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.controllers.AbstractController;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.dao.ProjectMappingDAO;
import com.cts.nw.onboarding.dao.ReleaseSummaryDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.ReleaseService;

/**
 * @author 656579
 *
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {

	@Autowired
	EmployeeProjHistDAO employeeProjHistDAO;

	@Autowired
	ProjectMappingDAO projectMappingDAO;

	@Autowired
	ReleaseSummaryDAO releaseSummaryDAO;
	
	@Autowired
	MailService mailService;

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleased() {
		return employeeProjHistDAO.getEmployeestobeReleased();
	}

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId) {
		return employeeProjHistDAO.getEmployeestobeReleasedbyTeam(teamId);
	}

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyProject(String projectId) {
		return employeeProjHistDAO.getEmployeestobeReleasedbyProj(projectId);
	}

	@Override
	public EmployeeProjHist getEmployeetoRelease(String empProjHistId) {
		return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
	}

	@Override
	public Integer releaseAnEmployee(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		try{
		ProjectMapping projDetail = projectMappingDAO.getProcesssorPerProjectId(String.valueOf(employeeProjHist.getProjectId()));
		employeeProjHist.setOffboardProcessor(String.valueOf(projDetail.getProcessorId()));
		employeeProjHist.setOffboardRequester(AbstractController.APPINFO.getLoggedInUserId());
		rowsAffected = employeeProjHistDAO.offboardEmployee(employeeProjHist,employeeProjHist.getId());
		if (rowsAffected > 0) {
			if (employeeProjHist.getReleaseStatusId() == 2) {
				 mailService.offBoardingInitiated(employeeProjHist);
			} else if (employeeProjHist.getReleaseStatusId() == 3) {
				 mailService.offBoardingCompleted(employeeProjHist);
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return rowsAffected;

	}

	@Override
	public List<ReleaseSummary> getAllReleaseSummary() {
		return releaseSummaryDAO.getAllReleaseSummary();
	}

	@Override
	public Integer releaseEmployeesByTeam(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		List<EmployeeProjHist> listofResources = employeeProjHistDAO
				.getEmployeestobeReleasedbyTeam(String.valueOf(employeeProjHist.getTeamId()));
		for (EmployeeProjHist resource : listofResources) {
			rowsAffected = rowsAffected + releaseAnEmployee(resource);
		}
		return rowsAffected;
	}

	@Override
	public Integer releaseEmployeesByProject(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		List<EmployeeProjHist> listofResources = employeeProjHistDAO
				.getEmployeestobeReleasedbyProj(String.valueOf(employeeProjHist.getProjectId()));
		for (EmployeeProjHist resource : listofResources) {
			rowsAffected = rowsAffected + releaseAnEmployee(resource);
		}

		return rowsAffected;
	}

}
