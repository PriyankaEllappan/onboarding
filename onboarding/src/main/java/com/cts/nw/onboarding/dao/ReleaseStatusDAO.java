/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ReleaseStatus;

/**
 * @author 616550
 *
 */
public interface ReleaseStatusDAO {

	ReleaseStatus getReleaseStatusID(String releaseStatus);
	List<ReleaseStatus> getAllReleaseStatus();
}