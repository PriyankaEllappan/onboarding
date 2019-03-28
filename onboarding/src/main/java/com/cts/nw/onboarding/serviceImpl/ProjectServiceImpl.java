/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
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
	
	Logger log = Logger.getLogger(ProjectServiceImpl.class) ;
	
	@Autowired
	ProjectMappingDAO projectMappingDAO;

	@Override
	public List<ProjectMapping> getAllActiveProjects() {
		try {
			return projectMappingDAO.getAllActiveProjectDetails();	
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			return null;
		}
	}

}
