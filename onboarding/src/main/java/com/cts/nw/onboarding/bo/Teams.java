/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 616550
 *
 */
public class Teams {

	private Integer id;
	private String teamName;
	private Integer projMapId;
	private String status;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * @param teamName the teamName to set
	 */
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teams [id=" + id + ", teamName=" + teamName + ", projMapId=" + projMapId + ", status=" + status + "]";
	}
}
