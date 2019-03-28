/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.EmployeeProjHist;
import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.controllers.AbstractController;
import com.cts.nw.onboarding.dao.EmployeeProjHistDAO;
import com.cts.nw.onboarding.dao.ProjectMappingDAO;
import com.cts.nw.onboarding.dao.ReleaseSummaryDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.ReleaseService;

/**
 * @author 656579
 *
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {
	
	Logger log = Logger.getLogger(ReleaseServiceImpl.class) ;

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
		try {
			return employeeProjHistDAO.getEmployeestobeReleased();	
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId) {
		try {
			return employeeProjHistDAO.getEmployeestobeReleasedbyTeam(teamId);
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyProject(String projectId) {
		try {
			return employeeProjHistDAO.getEmployeestobeReleasedbyProj(projectId);
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public EmployeeProjHist getEmployeetoRelease(String empProjHistId) {
		try {
			return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer releaseAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException {

		try {
			Integer rowsAffected = 0;
			ProjectMapping projDetail = projectMappingDAO
					.getProcesssorPerProjectId(String.valueOf(employeeProjHist.getProjectId()));
			employeeProjHist.setOffboardProcessor(String.valueOf(projDetail.getProcessorId()));
			employeeProjHist.setOffboardRequester(AbstractController.APPINFO.getLoggedInUserId());
			rowsAffected = employeeProjHistDAO.offboardEmployee(employeeProjHist, employeeProjHist.getId());
			if (rowsAffected > 0) {
				if (employeeProjHist.getReleaseStatusId() == 2) {
					mailService.offBoardingInitiated(employeeProjHist);
				} else if (employeeProjHist.getReleaseStatusId() == 3) {
					mailService.offBoardingCompleted(employeeProjHist);
				}
			}
			return rowsAffected;
		} catch (Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			throw new CustomException("Error in Inserting",e);
		}
	}

	@Override
	public List<ReleaseSummary> getAllReleaseSummary() {
		try {
			return releaseSummaryDAO.getAllReleaseSummary();	
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer releaseEmployeesByTeam(EmployeeProjHist employeeProjHist) {
		try {
			Integer rowsAffected = 0;
			List<EmployeeProjHist> listofResources = employeeProjHistDAO
					.getEmployeestobeReleasedbyTeam(String.valueOf(employeeProjHist.getTeamId()));
			for (EmployeeProjHist resource : listofResources) {
				setReleaseValues(employeeProjHist, resource);
				rowsAffected = rowsAffected + releaseAnEmployee(resource);
			}
			return rowsAffected;	
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer releaseEmployeesByProject(EmployeeProjHist employeeProjHist) {
		try {
			Integer rowsAffected = 0;
			List<EmployeeProjHist> listofResources = employeeProjHistDAO
					.getEmployeestobeReleasedbyProj(String.valueOf(employeeProjHist.getProjectId()));
			for (EmployeeProjHist resource : listofResources) {
				setReleaseValues(employeeProjHist, resource);
				rowsAffected = rowsAffected + releaseAnEmployee(resource);
			}

			return rowsAffected;
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @param employeeProjHist
	 * @param resource
	 */
	private void setReleaseValues(EmployeeProjHist employeeProjHist, EmployeeProjHist resource) {
		resource.setReleaseStatusId(employeeProjHist.getReleaseStatusId());
		resource.setReasonForOffboarding(employeeProjHist.getReasonForOffboarding());
		resource.setReleaseDate(employeeProjHist.getReleaseDate());
	}

}
