/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.dao.ProjectMappingDAO;
import com.cts.nw.onboarding.service.ProjectService;

/**
 * @author 656579
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	ProjectMappingDAO projectMappingDAO;

	@Override
	public List<ProjectMapping> getAllActiveProjects() {
		try {
			return projectMappingDAO.getAllActiveProjectDetails();	
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
