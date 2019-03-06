package com.cts.nw.onboarding.bo;

public class Roles {
	/*
	CREATE TABLE ROLES(
	ID INT NOT NULL AUTO_INCREMENT,
	ROLE VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	private Integer id;
	private String role;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", role=" + role + "]";
	}
	
	
}
