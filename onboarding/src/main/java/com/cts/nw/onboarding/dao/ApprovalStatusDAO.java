/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ApprovalStatus;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface ApprovalStatusDAO {
	public ApprovalStatus getApprovalStatusbyID(String id) throws CustomException;
	public ApprovalStatus getApprovalStatus(String status) throws CustomException;
	public List<ApprovalStatus> getAllApprovalStatus() throws CustomException;
}
