/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.ProjectMapping;
import com.cts.nw.onboarding.dao.ProjectMappingDAO;
import com.cts.nw.onboarding.exception.CustomException;
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
	public List<ProjectMapping> getAllActiveProjects() throws CustomException {
		try {
			return projectMappingDAO.getAllActiveProjectDetails();	
		} catch (Exception e) {
			throw new CustomException(e);
		}
	}

}
