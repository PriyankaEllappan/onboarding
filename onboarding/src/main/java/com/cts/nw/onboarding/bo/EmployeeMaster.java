package com.cts.nw.onboarding.bo;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class EmployeeMaster {

	/**
	 * 
	 */

	/*CREATE TABLE EMPLOYEEMASTER (
		    ID INT NOT NULL,
		    NAME VARCHAR(64) NOT NULL,
		    FIRSTNAME VARCHAR(64),
		    LASTNAME VARCHAR(64),
		    DOB DATE,
		    PASSPORTNUMBER VARCHAR(16),
		    EMAIL VARCHAR(255),
		    PRIMARY KEY (ID)
	);*/
	
	private Integer ID;
	private String name;
	private String firstName;
	private String lastName;
	private String passportNumber;
	private String email;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date DOB;

	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dOB
	 */
	public Date getDOB() {
		return DOB;
	}

	/**
	 * @param dOB the dOB to set
	 */
	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	/**
	 * @return the passportNumber
	 */
	public String getPassportNumber() {
		return passportNumber;
	}

	/**
	 * @param passportNumber the passportNumber to set
	 */
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeMaster [ID=" + ID + ", name=" + name + ", firstName=" + firstName + ", lastName=" + lastName +
				 ", DOB=" + DOB + 
				", passportNumber=" + passportNumber + ", email=" + email + "]";
	}

}
