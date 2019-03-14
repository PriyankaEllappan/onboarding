/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.ApprovalStatus;
import com.cts.nw.onboarding.bo.ReleaseStatus;
import com.cts.nw.onboarding.dao.ApprovalStatusDAO;
import com.cts.nw.onboarding.dao.ReleaseStatusDAO;
import com.cts.nw.onboarding.service.StatusService;

/**
 * @author 656579
 *
 */
@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	ApprovalStatusDAO approvalStatusDAO;
	
	@Autowired
	ReleaseStatusDAO releaseStatusDAO;
	
	@Override
	public List<ReleaseStatus> getAllReleaseStatus() {
		return releaseStatusDAO.getAllReleaseStatus();
	}

	@Override
	public List<ApprovalStatus> getAllApprovalStatus() {
		return approvalStatusDAO.getAllApprovalStatus();
	}

}