/**
 * 
 */
package com.cts.nw.onboarding.bo;
import org.springframework.stereotype.Component;

/**
 * @author 616550
 *
 */

	/*CREATE TABLE TEAMMAPPING (
	    ID INT NOT NULL AUTO_INCREMENT,
	    PROJECTMAPID INT NOT NULL,
	    TEAMID INT NOT NULL,
	    PPLMAPID INT NOT NULL,
	    STATUS VARCHAR(20) DEFAULT ‘ACTIVE’,
	    PRIMARY KEY (ID),
	    FOREIGN KEY (TEAMID)
	        REFERENCES TEAMS (ID),
	    FOREIGN KEY (PROJECTMAPID)
	        REFERENCES PROJECTMAPPING (ID),
	    FOREIGN KEY (PPLMAPID)
	        REFERENCES PPLMAPPING (ID)
	);*/

@Component
public class TeamProjectHierarchy {

	private Integer teamMapID;
	private Integer projectID;
	private String projectName;
	private Integer requesterID;
	private String requesterName;
	private Integer processorID;
	private String processorName;
	private Integer bsaID;
	private String bsa;
	private Integer pplID;
	private String pplName;
	private String status;
	private String teamName;
	/**
	 * @return the teamMapID
	 */
	public Integer getTeamMapID() {
		return teamMapID;
	}
	/**
	 * @param teamMapID the teamMapID to set
	 */
	public void setTeamMapID(Integer teamMapID) {
		this.teamMapID = teamMapID;
	}
	/**
	 * @return the projectID
	 */
	public Integer getProjectID() {
		return projectID;
	}
	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(Integer projectID) {
		this.projectID = projectID;
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
	 * @return the requesterID
	 */
	public Integer getRequesterID() {
		return requesterID;
	}
	/**
	 * @param requesterID the requesterID to set
	 */
	public void setRequesterID(Integer requesterID) {
		this.requesterID = requesterID;
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
	 * @return the processorID
	 */
	public Integer getProcessorID() {
		return processorID;
	}
	/**
	 * @param processorID the processorID to set
	 */
	public void setProcessorID(Integer processorID) {
		this.processorID = processorID;
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
	 * @return the bsaID
	 */
	public Integer getBsaID() {
		return bsaID;
	}
	/**
	 * @param bsaID the bsaID to set
	 */
	public void setBsaID(Integer bsaID) {
		this.bsaID = bsaID;
	}
	/**
	 * @return the bsa
	 */
	public String getBsa() {
		return bsa;
	}
	/**
	 * @param bsa the bsa to set
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
	}
	/**
	 * @return the pplID
	 */
	public Integer getPplID() {
		return pplID;
	}
	/**
	 * @param pplID the pplID to set
	 */
	public void setPplID(Integer pplID) {
		this.pplID = pplID;
	}
	/**
	 * @return the pplName
	 */
	public String getPplName() {
		return pplName;
	}
	/**
	 * @param pplName the pplName to set
	 */
	public void setPplName(String pplName) {
		this.pplName = pplName;
	}
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TeamProjectHierarchy [teamMapID=" + teamMapID + ", projectID=" + projectID + ", projectName="
				+ projectName + ", requesterID=" + requesterID + ", requesterName=" + requesterName + ", processorID="
				+ processorID + ", processorName=" + processorName + ", bsaID=" + bsaID + ", bsa=" + bsa + ", pplID="
				+ pplID + ", pplName=" + pplName + ", status=" + status + ", teamName=" + teamName + "]";
	}
	

}
