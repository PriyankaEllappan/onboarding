/**
 * 
 */
package com.cts.nw.onboarding.dao;

import com.cts.nw.onboarding.bo.MailAttachment;

/**
 * @author 656579
 *
 */
public interface MailAttachmentDAO {

	MailAttachment downloadAttachment(String id);
	Integer uploadAttachmentViaCallable(MailAttachment mailAttachment);
}
