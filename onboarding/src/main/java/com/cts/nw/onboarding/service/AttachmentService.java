/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.MailAttachment;

/**
 * @author 656579
 *
 */
public interface AttachmentService {

	MailAttachment downloadAttachment(String id);
	
}
