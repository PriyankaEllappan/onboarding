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
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.exception.ValidatorException;
import com.cts.nw.onboarding.service.MailService;
import com.cts.nw.onboarding.service.ReleaseService;
import com.cts.nw.onboarding.validators.OnboardingRequestValidator;

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

	@Autowired
	OnboardingRequestValidator onboardingRequestValidator;
	
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleased() throws CustomException {
		try {
			return employeeProjHistDAO.getEmployeestobeReleased();	
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyId(String empID) throws CustomException {
		try {
			return employeeProjHistDAO.getEmployeestobeReleasedbyId(empID);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}
	
	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyTeam(String teamId) throws CustomException {
		try {
			return employeeProjHistDAO.getEmployeestobeReleasedbyTeam(teamId);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public List<EmployeeProjHist> getEmployeestobeReleasedbyProject(String projectId) throws CustomException {
		try {
			return employeeProjHistDAO.getEmployeestobeReleasedbyProj(projectId);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public EmployeeProjHist getEmployeetoRelease(String empProjHistId) throws CustomException {
		try {
			return employeeProjHistDAO.getSpecificEmployeeProjectHist(empProjHistId);
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public Integer releaseAnEmployee(EmployeeProjHist employeeProjHist) throws CustomException, ValidatorException {
		Integer rowsAffected = 0;
		try {
			if(onboardingRequestValidator.validateReleaseForm(employeeProjHist)){
				
				ProjectMapping projDetail = projectMappingDAO
						.getProcesssorPerProjectId(String.valueOf(employeeProjHist.getProjectId()));
				employeeProjHist.setOffboardProcessor(String.valueOf(projDetail.getProcessorId()));
				employeeProjHist.setOffboardRequester(AbstractController.APPINFO.getLoggedInUserId());
				rowsAffected = employeeProjHistDAO.offboardEmployee(employeeProjHist, employeeProjHist.getId());
				if (rowsAffected > 0) {
					if (employeeProjHist.getReleaseStatusId() == 2) {
						mailService.offBoardingInitiated(employeeProjHist);
					}
				}
			}
		} catch (ValidatorException e) {
			throw new ValidatorException(e.getMessage());
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
		return rowsAffected;
	}

	@Override
	public List<ReleaseSummary> getAllReleaseSummary() throws CustomException {
		try {
			return releaseSummaryDAO.getAllReleaseSummary();	
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public Integer releaseEmployeesByTeam(EmployeeProjHist employeeProjHist) throws CustomException, ValidatorException {
		try {
			Integer rowsAffected = 0;
			List<EmployeeProjHist> listofResources = employeeProjHistDAO
					.getEmployeestobeReleasedbyTeam(String.valueOf(employeeProjHist.getTeamId()));
			for (EmployeeProjHist resource : listofResources) {
				setReleaseValues(employeeProjHist, resource);
				rowsAffected = rowsAffected + releaseAnEmployee(resource);
			}
			return rowsAffected;	
		} catch (ValidatorException e) {
			throw new ValidatorException(e.getMessage());
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	@Override
	public Integer releaseEmployeesByProject(EmployeeProjHist employeeProjHist)
			throws CustomException, ValidatorException {
		try {
			Integer rowsAffected = 0;
			List<EmployeeProjHist> listofResources = employeeProjHistDAO
					.getEmployeestobeReleasedbyProj(String.valueOf(employeeProjHist.getProjectId()));
			for (EmployeeProjHist resource : listofResources) {
				setReleaseValues(employeeProjHist, resource);
				rowsAffected = rowsAffected + releaseAnEmployee(resource);
			}
			return rowsAffected;
		} catch (ValidatorException e) {
			throw new ValidatorException(e.getMessage());
		} catch (Exception e) {
			throw new CustomException(e.getMessage());
		}
	}

	/**
	 * @param employeeProjHist
	 * @param resource
	 * @throws CustomException 
	 */
	private void setReleaseValues(EmployeeProjHist employeeProjHist, EmployeeProjHist resource) throws ValidatorException, CustomException {
		try{
			if(onboardingRequestValidator.validateReleaseForm(employeeProjHist)){
				resource.setReleaseStatusId(employeeProjHist.getReleaseStatusId());
				resource.setReasonForOffboarding(employeeProjHist.getReasonForOffboarding());
				resource.setReleaseDate(employeeProjHist.getReleaseDate());
			}
		} catch (ValidatorException e) {
			throw new ValidatorException(e.getMessage());
		}
	}

}
