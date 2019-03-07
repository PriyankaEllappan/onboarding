/**
 * 
 */
package com.cts.nw.onboarding.vo;

/**
 * @author 656579
 *
 */
public class EmployeeDetails {

	private String name;
	private Integer associateId;
	private String emailId;
	private String distinguishedName;
	private String designation;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the associateId
	 */
	public Integer getAssociateId() {
		return associateId;
	}
	/**
	 * @param associateId the associateId to set
	 */
	public void setAssociateId(Integer associateId) {
		this.associateId = associateId;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the distinguishedName
	 */
	public String getDistinguishedName() {
		return distinguishedName;
	}
	/**
	 * @param distinguishedName the distinguishedName to set
	 */
	public void setDistinguishedName(String distinguishedName) {
		this.distinguishedName = distinguishedName;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", associateId=" + associateId + ", emailId=" + emailId
				+ ", distinguishedName=" + distinguishedName + ", designation=" + designation + "]";
	}
	
}
