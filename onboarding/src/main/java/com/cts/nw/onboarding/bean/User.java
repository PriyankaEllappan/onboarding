package com.cts.nw.onboarding.bean;

public class User {

	private Integer empID;
	private String role;
	/**
	 * @return the empID
	 */
	public Integer getEmpID() {
		return empID;
	}
	/**
	 * @param empID the empID to set
	 */
	public void setEmpID(Integer empID) {
		this.empID = empID;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [empID=" + empID + ", role=" + role + "]";
	}

	
	
	
}
