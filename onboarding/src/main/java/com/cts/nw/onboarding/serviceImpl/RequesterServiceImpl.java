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
import com.cts.nw.onboarding.dao.EmployeeMasterDAO;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.dao.TeamsDAO;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.RequesterService;

/**
 * @author 656579
 *
 */
@Service
public class RequesterServiceImpl implements RequesterService {

	@Autowired
	private EmployeeMasterDAO employeeMasterDAO;

	@Autowired
	EmployeeProjHistDAO employeeProjHistDAO;

	@Autowired
	TeamsDAO teamsDAO;

	@Autowired
	MailService mailService;

	@Override
	public EmployeeMaster getResourceByID(String employeeid) {
		try {
			return employeeMasterDAO.getEmployeeMasterDetailsByID(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeMaster> getAllEmployees() {
		try {
			return employeeMasterDAO.getAllEmployeeMasterDetails();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeMaster addNewResource(EmployeeMaster employee) {
		try {
			Integer rowsAffected = 0;
			rowsAffected = employeeMasterDAO.addNewResource(employee);
			if (rowsAffected > 0) {
				return employee;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmployeeProjHist addNewProject(EmployeeProjHist employeeProjHist) {
		try {
			Integer rowsAffected = 0;
			System.out.println("Process Emp" + employeeProjHist.toString());
			if (employeeProjHist.getTeamId() == 0) {
				Teams team = new Teams();
				Integer teamId;
				team.setTeamName(employeeProjHist.getTeamName());
				team.setProjMapId(employeeProjHist.getProjectMappingId());
				team.setStatus("ACTIVE");
				teamId = teamsDAO.insertNewViaCallable(team);
				System.out.println(teamId);
				if (teamId != null) {
					employeeProjHist.setTeamId(teamId);
					rowsAffected = employeeProjHistDAO.addEmployeeProjectInfo(employeeProjHist);
				}
			} else {
				rowsAffected = employeeProjHistDAO.addEmployeeProjectInfo(employeeProjHist);
			}
			if (rowsAffected > 0) {
				// mailService.onBoardingInitiated(employeeProjJson);
				return employeeProjHist;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<EmployeeProjHist> checkActiveAssignments(String employeeid) {
		try {
			return employeeProjHistDAO.checkActiveAssignments(employeeid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
