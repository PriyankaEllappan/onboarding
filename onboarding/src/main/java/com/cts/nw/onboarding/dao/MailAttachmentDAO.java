/**
 * 
 */
package com.cts.nw.onboarding.dao;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.exception.CustomException;

/**
 * @author 656579
 *
 */
public interface MailAttachmentDAO {

	MailAttachment downloadAttachment(String id);
	Integer uploadAttachmentViaCallable(MailAttachment mailAttachment) throws CustomException;
}
