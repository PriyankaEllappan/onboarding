package com.cts.nw.onboarding.bo;

public class BSAInfo {

	/*
	CREATE TABLE BSAINFO(
	ID INT NOT NULL AUTO_INCREMENT,
	BSA VARCHAR(255),
	PRIMARY KEY(ID));
	*/
	private Integer id;
	private String BSA;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBSA() {
		return BSA;
	}
	public void setBSA(String bSA) {
		BSA = bSA;
	}
	@Override
	public String toString() {
		return "BSAInfo [id=" + id + ", BSA=" + BSA + "]";
	}
	
	
}
