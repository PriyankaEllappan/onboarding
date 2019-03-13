/**
 * 
 */
package com.cts.nw.onboarding.bo;

import java.util.List;

/**
 * @author 656579
 *
 */
public class MailDetail {
	private List<String> receiver;
	private String content;
	private String subject;
	private List<String> cc;
	/**
	 * @return the receiver
	 */
	public List<String> getReceiver() {
		return receiver;
	}
	/**
	 * @param receiver the receiver to set
	 */
	public void setReceiver(List<String> receiver) {
		this.receiver = receiver;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the cc
	 */
	public List<String> getCc() {
		return cc;
	}
	/**
	 * @param cc the cc to set
	 */
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MailDetail [receiver=" + receiver + ", content=" + content + ", subject=" + subject + ", cc=" + cc
				+ "]";
	}
}
