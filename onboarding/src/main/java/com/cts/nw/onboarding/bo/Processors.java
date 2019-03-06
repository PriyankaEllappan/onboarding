package com.cts.nw.onboarding.bo;

public class Processors {

	/*
	CREATE TABLE PROCESSORS(
	PROCESSORID INT NOT NULL,
	PROCESSORNAME VARCHAR(255),
	PRIMARY KEY(PROCESSORID));
	*/
	
	private Integer processorID;
	private String processorName;
	public Integer getProcessorID() {
		return processorID;
	}
	public void setProcessorID(Integer processorID) {
		this.processorID = processorID;
	}
	public String getProcessorName() {
		return processorName;
	}
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	@Override
	public String toString() {
		return "Processors [processorID=" + processorID + ", processorName=" + processorName + "]";
	}

	
	
}
