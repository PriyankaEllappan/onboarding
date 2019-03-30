/**
 * 
 */
package com.cts.nw.onboarding.service;

import java.util.List;

import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface ProjectService {

	List<ProjectMapping> getAllActiveProjects() throws CustomException;
	
}
