/**
 * 
 */
package com.cts.nw.onboarding.bo;

/**
 * @author 616550
 *
 */
public class Roles {
	
	private Integer id;
	private String roleName;
	private String parentRole;
	
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	/**
	 * @return the parentRole
	 */
	public String getParentRole() {
		return parentRole;
	}
	/**
	 * @param parentRole the parentRole to set
	 */
	public void setParentRole(String parentRole) {
		this.parentRole = parentRole;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Roles [id=" + id + ", roleName=" + roleName + ", parentRole=" + parentRole + "]";
	}
	

}
