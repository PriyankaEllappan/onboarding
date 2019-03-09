/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ApprovalStatus;

/**
 * @author 616550
 *
 */
public interface ApprovalStatusDAO {
	
	ApprovalStatus getApprovalStatusID(String approvalStatus);
	List<ApprovalStatus> getAllApprovalStatus();

}

