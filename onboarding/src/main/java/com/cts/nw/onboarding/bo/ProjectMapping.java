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
	private Integer bsaId;
	private String bsaName;
	private String projStatus;
	
	
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
	 * @return the bsaId
	 */
	public Integer getBsaId() {
		return bsaId;
	}


	/**
	 * @param bsaId the bsaId to set
	 */
	public void setBsaId(Integer bsaId) {
		this.bsaId = bsaId;
	}


	/**
	 * @return the bsaName
	 */
	public String getBsaName() {
		return bsaName;
	}


	/**
	 * @param bsaName the bsaName to set
	 */
	public void setBsaName(String bsaName) {
		this.bsaName = bsaName;
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


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProjectMapping [ projectId=" + projectId
				+ ", projectName=" + projectName + ", requesterId=" + requesterId + ", requesterName=" + requesterName
				+ ", processorId=" + processorId + ", processorName=" + processorName + ", bsaId=" + bsaId
				+ ", bsaName=" + bsaName + ", projStatus=" + projStatus + "]";
	}
	
	
	
}
