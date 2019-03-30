/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 616550
 *
 */
public interface ProjectMappingDAO {

	List<ProjectMapping> getAllActiveProjectDetails() throws CustomException;	
	ProjectMapping getProcesssorPerProjectId(String projectId) throws CustomException;
}
