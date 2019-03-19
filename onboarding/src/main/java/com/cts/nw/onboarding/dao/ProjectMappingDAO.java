/**
 * 
 */
package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ProjectMapping;

/**
 * @author 616550
 *
 */
public interface ProjectMappingDAO {

	List<ProjectMapping> getAllActiveProjectDetails();	
	ProjectMapping getProcesssorPerProjectId(String projectId);
}
