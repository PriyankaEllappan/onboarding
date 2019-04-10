/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 616550
 *
 */
public class ProjectMapping {

	private Long projectId;
	private String projectName;
	private Integer requesterId;
	private String requesterName;
	private Integer processorId;
	private String processorName;
	private String projStatus;
	private Integer projMapId;
	private boolean isMcaProject;

	/**
	 * @return the projMapId
	 */
	public Integer getProjMapId() {
		return projMapId;
	}


	/**
	 * @param projMapId the projMapId to set
	 */
	public void setProjMapId(Integer projMapId) {
		this.projMapId = projMapId;
	}


	/**
	 * @return the projectId
	 */
	public Long getProjectId() {
		return projectId;
	}


	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}


	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}


	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	/**
	 * @return the requesterId
	 */
	public Integer getRequesterId() {
		return requesterId;
	}


	/**
	 * @param requesterId the requesterId to set
	 */
	public void setRequesterId(Integer requesterId) {
		this.requesterId = requesterId;
	}


	/**
	 * @return the requesterName
	 */
	public String getRequesterName() {
		return requesterName;
	}


	/**
	 * @param requesterName the requesterName to set
	 */
	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}


	/**
	 * @return the processorId
	 */
	public Integer getProcessorId() {
		return processorId;
	}


	/**
	 * @param processorId the processorId to set
	 */
	public void setProcessorId(Integer processorId) {
		this.processorId = processorId;
	}


	/**
	 * @return the processorName
	 */
	public String getProcessorName() {
		return processorName;
	}


	/**
	 * @param processorName the processorName to set
	 */
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}

	/**
	 * @return the projStatus
	 */
	public String getProjStatus() {
		return projStatus;
	}

	/**
	 * @param projStatus the projStatus to set
	 */
	public void setProjStatus(String projStatus) {
		this.projStatus = projStatus;
	}

	/**
	 * @return the isMcaProject
	 */
	public boolean isMcaProject() {
		return isMcaProject;
	}


	/**
	 * @param isMcaProject the isMcaProject to set
	 */
	public void setMcaProject(boolean isMcaProject) {
		this.isMcaProject = isMcaProject;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectMapping [projectId=" + projectId + ", projectName=" + projectName + ", requesterId="
				+ requesterId + ", requesterName=" + requesterName + ", processorId=" + processorId + ", processorName="
				+ processorName + ", projStatus=" + projStatus + ", projMapId=" + projMapId + ", isMcaProject="
				+ isMcaProject + "]";
	}

}
