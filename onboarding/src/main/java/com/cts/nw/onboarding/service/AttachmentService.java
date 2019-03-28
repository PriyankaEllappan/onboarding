/**
 * 
 */
package com.cts.nw.onboarding.service;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface AttachmentService {

	MailAttachment downloadAttachment(String id) throws CustomException;
	
}
