/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 616550
 *
 */
public class RoleMapping {
	
	private Integer roleMappingID;
	private String rateValue;
	private Integer roleId;
	private Integer countryMappingID;
	/**
	 * @return the roleMappingID
	 */
	public Integer getRoleMappingID() {
		return roleMappingID;
	}
	/**
	 * @param roleMappingID the roleMappingID to set
	 */
	public void setRoleMappingID(Integer roleMappingID) {
		this.roleMappingID = roleMappingID;
	}
	/**
	 * @return the rateValue
	 */
	public String getRateValue() {
		return rateValue;
	}
	/**
	 * @param rateValue the rateValue to set
	 */
	public void setRateValue(String rateValue) {
		this.rateValue = rateValue;
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
	 * @return the countryMappingID
	 */
	public Integer getCountryMappingID() {
		return countryMappingID;
	}
	/**
	 * @param countryMappingID the countryMappingID to set
	 */
	public void setCountryMappingID(Integer countryMappingID) {
		this.countryMappingID = countryMappingID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoleMapping [roleMappingID=" + roleMappingID + ", rateValue=" + rateValue + ", roleId=" + roleId
				+ ", countryMappingID=" + countryMappingID + "]";
	}
	
	
	
	

}
