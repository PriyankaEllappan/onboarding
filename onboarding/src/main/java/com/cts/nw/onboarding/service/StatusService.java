/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.ApprovalStatus;
import com.cts.nw.onboarding.bo.ReleaseStatus;

/**
 * @author 656579
 *
 */
public interface StatusService {

	List<ReleaseStatus> getAllReleaseStatus();
	List<ApprovalStatus> getAllApprovalStatus();
}
