/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ReleaseStatus;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface ReleaseStatusDAO {
	List<ReleaseStatus> getAllReleaseStatus() throws CustomException;
}
