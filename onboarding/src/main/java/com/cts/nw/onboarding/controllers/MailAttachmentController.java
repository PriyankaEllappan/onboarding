/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.service.AttachmentService;

/**
 * @author 656579
 *
 */
@Controller
@RequestMapping("/attachment")
public class MailAttachmentController extends AbstractController {

	@Autowired
	AttachmentService attachmentService;
	
	@GetMapping(value = "/upload")
	public String addImageForm() {
		return "fileupload";
	}

	@PostMapping(value = "/upload")
	public @ResponseBody Integer saveUploadedFileInDatabase(@RequestParam CommonsMultipartFile[] attachFileObj) {
		System.out.println("In");
		if(attachFileObj != null){
			System.out.println("Yes");
		}
		return attachmentService.uploadAttachment(attachFileObj);
	}

	@GetMapping(value = "/getfile/{attachmentID}")
	public @ResponseBody HttpEntity<byte[]> downloadFileFromDatabase(@PathVariable("attachmentID") String attachmentID) {
		MailAttachment filedetail = attachmentService.downloadAttachment(attachmentID);
		HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "txt"));
        header.set("Content-Disposition", "inline; filename=" + filedetail.getFileName());
        return new HttpEntity<byte[]>(filedetail.getData(), header);
	}
	
}
