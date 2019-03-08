/**
 * 
 */
package com.cts.nw.onboarding.responses;

import com.cts.nw.onboarding.bo.EmployeeMaster;

/**
 * @author 656579
 *
 */
public class JsonEmployeeMasterResponse {

	private EmployeeMaster employeeMaster;
	private boolean status;
	private String statusMessage;
	
	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}
	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	/**
	 * @return the employeeMaster
	 */
	public EmployeeMaster getEmployeeMaster() {
		return employeeMaster;
	}
	/**
	 * @param employeeMaster the employeeMaster to set
	 */
	public void setEmployeeMaster(EmployeeMaster employeeMaster) {
		this.employeeMaster = employeeMaster;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
