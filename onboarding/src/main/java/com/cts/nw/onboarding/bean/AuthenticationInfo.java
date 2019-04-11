/**
 * 
 */
package com.cts.nw.onboarding.bean;

/**
 * @author 656579
 *
 */
public class AuthenticationInfo {

	private String userName;
	private String currPassword;
	private String newPassword;
	private int isEnabled;
	private String mailPin;
	private String hiddenPin;
	
	/**
	 * @return the hiddenPin
	 */
	public String getHiddenPin() {
		return hiddenPin;
	}
	/**
	 * @param hiddenPin the hiddenPin to set
	 */
	public void setHiddenPin(String hiddenPin) {
		this.hiddenPin = hiddenPin;
	}
	/**
	 * @return the mailPin
	 */
	public String getMailPin() {
		return mailPin;
	}
	/**
	 * @param mailPin the mailPin to set
	 */
	public void setMailPin(String mailPin) {
		this.mailPin = mailPin;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the currPassword
	 */
	public String getCurrPassword() {
		return currPassword;
	}
	/**
	 * @param currPassword the currPassword to set
	 */
	public void setCurrPassword(String currPassword) {
		this.currPassword = currPassword;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	/**
	 * @return the isEnabled
	 */
	public int getIsEnabled() {
		return isEnabled;
	}
	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setIsEnabled(int isEnabled) {
		this.isEnabled = isEnabled;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AuthenticationInfo [userName=" + userName + ", currPassword=" + currPassword + ", newPassword="
				+ newPassword + ", isEnabled=" + isEnabled + ", mailPin=" + mailPin + ", hiddenPin=" + hiddenPin + "]";
	}
	
}
