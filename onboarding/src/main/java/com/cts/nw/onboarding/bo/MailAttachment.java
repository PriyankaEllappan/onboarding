/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 656579
 *
 */
public class MailAttachment {

	private Integer id;
	private byte[] onboardData;
	private byte[] offboardData;
	private String onboardFileName;
	private String offboardFileName;
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
	 * @return the onboardData
	 */
	public byte[] getOnboardData() {
		return onboardData;
	}
	/**
	 * @param onboardData the onboardData to set
	 */
	public void setOnboardData(byte[] onboardData) {
		this.onboardData = onboardData;
	}
	/**
	 * @return the offboardData
	 */
	public byte[] getOffboardData() {
		return offboardData;
	}
	/**
	 * @param offboardData the offboardData to set
	 */
	public void setOffboardData(byte[] offboardData) {
		this.offboardData = offboardData;
	}
	/**
	 * @return the onboardFileName
	 */
	public String getOnboardFileName() {
		return onboardFileName;
	}
	/**
	 * @param onboardFileName the onboardFileName to set
	 */
	public void setOnboardFileName(String onboardFileName) {
		this.onboardFileName = onboardFileName;
	}
	/**
	 * @return the offboardFileName
	 */
	public String getOffboardFileName() {
		return offboardFileName;
	}
	/**
	 * @param offboardFileName the offboardFileName to set
	 */
	public void setOffboardFileName(String offboardFileName) {
		this.offboardFileName = offboardFileName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MailAttachment [id=" + id + ", onboardFileName=" + onboardFileName + ", offboardFileName="
				+ offboardFileName + "]";
	}
	
}
