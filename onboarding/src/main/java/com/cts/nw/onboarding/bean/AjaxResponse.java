/**
 * 
 */
package com.cts.nw.onboarding.bean;

import java.util.List;

/**
 * @author 656579
 *
 */
public class AjaxResponse {

	private String status;
	private String statusMessage;
	private Object responseObj;
	private List<Object> responseList;
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
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
	 * @return the responseObj
	 */
	public Object getResponseObj() {
		return responseObj;
	}
	/**
	 * @param responseObj the responseObj to set
	 */
	public void setResponseObj(Object responseObj) {
		this.responseObj = responseObj;
	}
	/**
	 * @return the responseList
	 */
	public List<Object> getResponseList() {
		return responseList;
	}
	/**
	 * @param responseList the responseList to set
	 */
	public void setResponseList(List<Object> responseList) {
		this.responseList = responseList;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AjaxResponse [status=" + status + ", statusMessage=" + statusMessage + ", responseObj=" + responseObj
				+ ", responseList=" + responseList + "]";
	}
	
}
