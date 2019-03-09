package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.ProcessorsInfo;
import com.cts.nw.onboarding.bo.ReleaseSummary;

/**
 * @author 656579
 *
 */
public interface ReleaseService {

	ProcessorsInfo getEmployeetoReleasebyId(String employeeId);
	List<ProcessorsInfo> getListofEmployeetoRelease(int releaseStatusID);
	List<ReleaseSummary> getAllReleaseSummary();
}
