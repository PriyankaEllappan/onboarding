/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.ProcessorsInfo;
import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.dao.ProcessorsInfoDAO;
import com.cts.nw.onboarding.dao.ReleaseSummaryDAO;
import com.cts.nw.onboarding.service.ReleaseService;

/**
 * @author 656579
 *
 */
@Service
public class ReleaseServiceImpl implements ReleaseService{

	@Autowired
	ReleaseSummaryDAO releaseSummaryDAO;
	
	@Autowired
	ProcessorsInfoDAO processorsInfoDAO;
	
	@Override
	public List<ProcessorsInfo> getListofEmployeetoRelease(int releaseStatusID) {
		return processorsInfoDAO.getEmployeesbyReleaseStatusId(releaseStatusID);
	}

	@Override
	public List<ReleaseSummary> getAllReleaseSummary() {
		return releaseSummaryDAO.getAllReleaseSummary();
	}

	@Override
	public ProcessorsInfo getEmployeetoReleasebyId(String projInfoId) {
		int infoId;
		infoId = Integer.parseInt(projInfoId);
		return processorsInfoDAO.getEmployeestoReleasebyId(infoId);
	}

	@Override
	public ProcessorsInfo releaseAnEmployee(ProcessorsInfo employeeProjJson) {
		Integer rowsAffected = 0;
		rowsAffected = processorsInfoDAO.releaseAnEmployee(employeeProjJson);
		if (rowsAffected > 0) {
			return employeeProjJson;
		}
		return null;
	}

	@Override
	public List<ProcessorsInfo> getEmployeesbyReleaseStatusId(int releaseStatusID) {
		return processorsInfoDAO.getEmployeesbyReleaseStatusId(releaseStatusID);
	}
	
}
