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
		try {
			return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeid);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeMaster addNewResource(EmployeeMaster employee) {
		try {
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
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*2. Map a Project*/
	
	@Override
	public EmployeeProjHist getEmployeeProjById(String empProjHistId) {
		try {
			return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeProjHist> checkActiveAssignments(String employeeid) {
		try {
			return employeeProjHistDAO.checkActiveAssignments(employeeid);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public EmployeeProjHist addNewProject(EmployeeProjHist employeeProjHist) {
		try {
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
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*3. Requester list*/
	
	@Override
	public List<EmployeeProjHist> getEmployeesPerRequester(String requesterId) {
		try {
			return employeeProjHistDAO.getEmployeesPerRequester(requesterId);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
