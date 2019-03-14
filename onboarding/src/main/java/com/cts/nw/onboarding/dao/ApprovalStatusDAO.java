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
	public ApprovalStatus getApprovalStatusbyID(String id);
	public ApprovalStatus getApprovalStatus(String status);
	public List<ApprovalStatus> getAllApprovalStatus();
}
