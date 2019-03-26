/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 656579
 *
 */
public class BSA {

	private String bsaId;
	private String bsaName;
	/**
	 * @return the bsaId
	 */
	public String getBsaId() {
		return bsaId;
	}
	/**
	 * @param bsaId the bsaId to set
	 */
	public void setBsaId(String bsaId) {
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BSA [bsaId=" + bsaId + ", bsaName=" + bsaName + "]";
	}
	
}
