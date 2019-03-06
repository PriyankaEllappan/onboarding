package com.cts.nw.onboarding.dao;

import java.util.List;

import com.cts.nw.onboarding.bo.ProjectMapping;

public interface ProjectMappingDAO {
    List<ProjectMapping> getAllProjectMapping();
    List<ProjectMapping> getAllProjectMappingByProjectID(int projectid);
    ProjectMapping getAllProjectMappingByID(int id);
    int updateProjectMapping(ProjectMapping projectMapping);
}