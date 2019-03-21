/**
 * 
 */
package com.cts.nw.onboarding.bean;

/**
 * @author 656579
 *
 */
public class AppInfo {

	private String loggedInUserId;
	private String loggedInUserName;
	private String loggedInUserRole;
	private String appUrl;
	
	
	/**
	 * @return the loggedInUserId
	 */
	public String getLoggedInUserId() {
		return loggedInUserId;
	}
	/**
	 * @param loggedInUserId the loggedInUserId to set
	 */
	public void setLoggedInUserId(String loggedInUserId) {
		this.loggedInUserId = loggedInUserId;
	}
	/**
	 * @return the loggedInUserName
	 */
	public String getLoggedInUserName() {
		return loggedInUserName;
	}
	/**
	 * @param loggedInUserName the loggedInUserName to set
	 */
	public void setLoggedInUserName(String loggedInUserName) {
		this.loggedInUserName = loggedInUserName;
	}
	/**
	 * @return the loggedInUserRole
	 */
	public String getLoggedInUserRole() {
		return loggedInUserRole;
	}
	/**
	 * @param loggedInUserRole the loggedInUserRole to set
	 */
	public void setLoggedInUserRole(String loggedInUserRole) {
		this.loggedInUserRole = loggedInUserRole;
	}
	
	/**
	 * @return the appUrl
	 */
	public String getAppUrl() {
		return appUrl;
	}
	/**
	 * @param appUrl the appUrl to set
	 */
	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AppInfo [loggedInUserId=" + loggedInUserId + ", loggedInUserName=" + loggedInUserName
				+ ", loggedInUserRole=" + loggedInUserRole + ", appUrl=" + appUrl + "]";
	}
	
}
