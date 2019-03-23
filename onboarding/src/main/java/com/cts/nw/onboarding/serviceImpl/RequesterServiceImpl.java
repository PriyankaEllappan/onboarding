/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeMaster;
import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.Teams;
import com.cts.nw.onboarding.controllers.AbstractController;
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.dao.TeamsDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.RequesterService;
import com.cts.nw.onboarding.validators.EmployeeMasterValidator;
import com.cts.nw.onboarding.validators.OnboardingRequestValidator;

/**
 * @author 656579
 *
 */
@Service
public class RequesterServiceImpl implements RequesterService {

	@Autowired
	private EmployeeMasterDAO employeeMasterDAO;

	@Autowired
	EmployeeMasterValidator employeeMasterValidator;
	
	@Autowired
	OnboardingRequestValidator onboardingRequestValidator;
	
	@Autowired
	EmployeeProjHistDAO employeeProjHistDAO;

	@Autowired
	TeamsDAO teamsDAO;

	@Autowired
	MailService mailService;

	/*1. Adding Resource*/
	@Override
	public EmployeeMaster getResourceByID(String employeeid) {
		return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeid);
	}

	@Override
	public EmployeeMaster addNewResource(EmployeeMaster employee) {
		Integer rowsAffected;
		if (employeeMasterValidator.validate(employee)) {
			rowsAffected = employeeMasterDAO.addNewResource(employee);
			if (rowsAffected > 0) {
				return employee;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/*2. Map a Project*/
	
	@Override
	public EmployeeProjHist getEmployeeProjById(String empProjHistId) {
		return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
	}

	@Override
	public List<EmployeeProjHist> checkActiveAssignments(String employeeid) {
		return employeeProjHistDAO.checkActiveAssignments(employeeid);
	}
	
	@Override
	public EmployeeProjHist addNewProject(EmployeeProjHist employeeProjHist) {
		Integer rowsAffected = 0;
		if (onboardingRequestValidator.validate(employeeProjHist)) {
			employeeProjHist.setOnboardRequester(AbstractController.APPINFO.getLoggedInUserId());
			if (employeeProjHist.getTeamId() == 0) {
				Teams team = new Teams();
				Integer teamId;
				team.setTeamName(employeeProjHist.getTeamName());
				team.setProjMapId(employeeProjHist.getProjectMappingId());
				team.setStatus("ACTIVE");
				teamId = teamsDAO.insertNewViaCallable(team);
				if (teamId != null) {
					employeeProjHist.setTeamId(teamId);
					rowsAffected = employeeProjHistDAO.addEmployeeProjectInfo(employeeProjHist);
				}
			} else {
				rowsAffected = employeeProjHistDAO.addEmployeeProjectInfo(employeeProjHist);
			}
			if (rowsAffected > 0) {
				mailService.onBoardingInitiated(employeeProjHist);
				return employeeProjHist;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/*3. Requester list*/
	
	@Override
	public List<EmployeeProjHist> getEmployeesPerRequester(String requesterId) {
		return employeeProjHistDAO.getEmployeesPerRequester(requesterId);
	}
	
}
