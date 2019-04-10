/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.constants.ErrorConstants;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.service.AttachmentService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/attachment")
public class MailAttachmentController extends AbstractController {

	Logger log = Logger.getLogger(ProcessController.class);
	
	@Autowired
	AttachmentService attachmentService;

	@GetMapping(value = "/getonboardfile/{attachmentID}")
	public @ResponseBody HttpEntity<byte[]> downloadOnboardFileFromDatabase(@PathVariable("attachmentID") String attachmentID) {
		MailAttachment filedetail;
		try {
			filedetail = attachmentService.downloadAttachment(attachmentID);
			HttpHeaders header = new HttpHeaders();
	        header.setContentType(new MediaType("application", "txt"));
	        header.set("Content-Disposition", "inline; filename=" + filedetail.getOnboardFileName());
	        return new HttpEntity<byte[]>(filedetail.getOnboardData(), header);
		} catch (CustomException e) {
			log.error(ErrorConstants.RESOURCENONAVAILABLE);
			return null;
		}
		
	}
	
	@GetMapping(value = "/getoffboardfile/{attachmentID}")
	public @ResponseBody HttpEntity<byte[]> downloadOffboardFileFromDatabase(@PathVariable("attachmentID") String attachmentID) {
		MailAttachment filedetail;
		try {
			filedetail = attachmentService.downloadAttachment(attachmentID);
			byte[] dateFile = filedetail.getOffboardData();
			String dataFileName = filedetail.getOffboardFileName();
			
			HttpHeaders header = new HttpHeaders();
	        header.setContentType(new MediaType("application", "txt"));
	        
	        if(dataFileName != null){
	        	 header.set("Content-Disposition", "inline; filename=" + dataFileName);
	        }else{
	        	 header.set("Content-Disposition", "inline; filename=" + "NoResource");
	        }
	        
	        if(dateFile != null){
	        	return new HttpEntity<byte[]>(dateFile, header);
	        }else{
	        	String resourceVal = "Requested resource is not available";
	        	return new HttpEntity<byte[]>(resourceVal.getBytes(), header);
	        }
	        
		} catch (CustomException e) {
			log.error(ErrorConstants.RESOURCENONAVAILABLE);
			return null;
		}
		
	}
}
