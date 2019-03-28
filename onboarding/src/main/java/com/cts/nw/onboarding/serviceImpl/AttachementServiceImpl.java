/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.dao.MailAttachmentDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.AttachmentService;

/**
 * @author 656579
 *
 */
@Service
public class AttachementServiceImpl implements AttachmentService {

	Logger log = Logger.getLogger(AttachementServiceImpl.class) ;
	
	@Autowired
	MailAttachmentDAO mailAttachmentDAO;

	@Override
	public MailAttachment downloadAttachment(String id) throws CustomException {
		try {
			return mailAttachmentDAO.downloadAttachment(id);
		} catch(Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
			throw new CustomException("Error in Inserting",e);
		}
		
	}

}
