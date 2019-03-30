/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ReleaseSummary;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface ReleaseSummaryDAO {
	
	List<ReleaseSummary> getAllReleaseSummary() throws CustomException;

}
