/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 616550
 *
 */
public class RoleMapping {

	private Integer id;
	private Integer roleId;
	private Integer rateId;
	private String rate;
	private Integer countryId;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @return the rate
	 */
	public String getRate() {
		return rate;
	}
	/**
	 * @param rate the rate to set
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the rateId
	 */
	public Integer getRateId() {
		return rateId;
	}
	/**
	 * @param rateId the rateId to set
	 */
	public void setRateId(Integer rateId) {
		this.rateId = rateId;
	}
	/**
	 * @return the countryId
	 */
	public Integer getCountryId() {
		return countryId;
	}
	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleMapping [id=" + id + ", roleId=" + roleId + ", rateId=" + rateId + ", rate=" + rate + ", countryId="
				+ countryId + "]";
	}
	
}
