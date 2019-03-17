/**
 * 
 */
package com.cts.nw.onboarding.util;

/**
 * @author 656579
 *
 */
public class AppInfo {

	private String loggedInUser;
	private String loggedInUserRole;
	private String appUrl;
	
	/**
	 * @return the loggedInUser
	 */
	public String getLoggedInUser() {
		return loggedInUser;
	}
	/**
	 * @param loggedInUser the loggedInUser to set
	 */
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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
		return "UserDetails [loggedInUser=" + loggedInUser + ", loggedInUserRole=" + loggedInUserRole + ", appUrl="
				+ appUrl + "]";
	}
	
}
