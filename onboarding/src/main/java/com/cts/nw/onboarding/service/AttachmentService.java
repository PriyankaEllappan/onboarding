/**
 * 
 */
package com.cts.nw.onboarding.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cts.nw.onboarding.bo.MailAttachment;

/**
 * @author 656579
 *
 */
public interface AttachmentService {

	Integer uploadAttachment(CommonsMultipartFile[] attachFileObj);
	MailAttachment downloadAttachment(String id);
	
}
