package com.cts.nw.onboarding.bo;

import java.util.Date;

public class EmployeeMaster {

	
	/*
	CREATE TABLE EMPLOYEEMASTER (
	    ID Int NOT NULL,
	    NAME VARCHAR(64) NOT NULL,
	    FIRSTNAME VARCHAR(64),
	    LASTNAME VARCHAR(64),
	    DOB DATE,
	    PASSPORTNUMBER VARCHAR(16),
	    PRIMARY KEY (ID)
	);
	*/
    private Integer ID;
    private String name;
    private String firstName;
    private String lastName;
	private Date DOB;
    private String passportNumber;

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	@Override
	public String toString() {
		return "EmployeeMaster [ID=" + ID + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", DOB=" + DOB + ", passportNumber=" + passportNumber + "]";
	}



    
    
	
}
