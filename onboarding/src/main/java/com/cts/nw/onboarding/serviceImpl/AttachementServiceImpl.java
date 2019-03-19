/**
 * 
 */
package com.cts.nw.onboarding.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.dao.MailAttachmentDAO;
import com.cts.nw.onboarding.service.AttachmentService;

/**
 * @author 656579
 *
 */
@Service
public class AttachementServiceImpl implements AttachmentService {

	@Autowired
	MailAttachmentDAO mailAttachmentDAO;
	
	@Override
	public Integer uploadAttachment(CommonsMultipartFile[] attachFileObj) {
		Integer fileId = 0;
		try {
			if ((attachFileObj != null) && (attachFileObj.length > 0) && (!attachFileObj.equals(""))) {
				for (CommonsMultipartFile aFile : attachFileObj) {
					if(aFile.isEmpty()) {
						continue;
					} else {
						if (!aFile.getOriginalFilename().equals("")) {
							MailAttachment fileUploadObj = new MailAttachment();
							fileUploadObj.setFileName(aFile.getOriginalFilename());
							fileUploadObj.setData(aFile.getBytes());
							//fileId = mailAttachmentDAO.uploadAttachment(fileUploadObj);
							fileId = mailAttachmentDAO.uploadAttachmentViaCallable(fileUploadObj);
						}
					}
					System.out.println("File Is Successfully Uploaded & Saved In The Database.... Hurrey!\n");
				}
			} else {
				System.out.println("Error in file Upload");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileId;
	}

	@Override
	public MailAttachment downloadAttachment(String id) {
		return mailAttachmentDAO.downloadAttachment(id);
	}

}
