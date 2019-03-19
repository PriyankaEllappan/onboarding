/**
 * 
 */
package com.cts.nw.onboarding.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cts.nw.onboarding.bo.CountryMapping;
import com.cts.nw.onboarding.bo.FileUpload;
import com.cts.nw.onboarding.mappers.CountryMappingRowMapper;
import com.cts.nw.onboarding.mappers.FileUploadRowMapper;
import com.cts.nw.onboarding.service.LDAPService;
import com.cts.nw.onboarding.util.EmployeeDetails;

/**
 * @author 616550
 *
 */
@Controller
@RequestMapping("/resource")
public class ResourceController extends AbstractController {

	// private static final Logger logger = Logger.getLogger(ResourceController.class);
	FileUpload fileUploadObj;
	String query = "INSERT INTO MAILATTACHMENTS(ID,FILENAME,FILEDATA) VALUES(?,?,?)";
	String query1 = "SELECT ID,FILENAME,FILEDATA FROM MAILATTACHMENTS WHERE ID=3";
	
	@Autowired
	LDAPService lDAPService;


	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "/getemployee", method = RequestMethod.GET)
	public @ResponseBody EmployeeDetails index(@RequestParam("empId") String empId) {
		EmployeeDetails employee = null;
		try {
			employee = lDAPService.getEmployee(empId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	@GetMapping(value = "/addfile")
	public String addImageForm() {
		return "fileupload";
	}
	
	@PostMapping(value = "/addfile")
	public ModelAndView saveUploadedFileInDatabase(HttpServletRequest request, final @RequestParam CommonsMultipartFile[] attachFileObj) throws IllegalStateException, IOException {
		ModelAndView modelViewObj;
		System.out.println("Heer");
		if ((attachFileObj != null) && (attachFileObj.length > 0) && (!attachFileObj.equals(""))) {
			for (CommonsMultipartFile aFile : attachFileObj) {
				if(aFile.isEmpty()) {
					continue;
				} else {
					System.out.println("Attachment Name?= " + aFile.getOriginalFilename() + "\n");
					if (!aFile.getOriginalFilename().equals("")) {
						fileUploadObj = new FileUpload();
						fileUploadObj.setFileName(aFile.getOriginalFilename());
						fileUploadObj.setData(aFile.getBytes());
						Integer x = jdbcTemplate.update(query,fileUploadObj.getId(),fileUploadObj.getFileName(),fileUploadObj.getData());
						System.out.println(x);
					}
				}
				System.out.println("File Is Successfully Uploaded & Saved In The Database.... Hurrey!\n");
			}
		} else {
			System.out.println("Error in file Upload");
		}
		modelViewObj = new ModelAndView("success","messageObj","Thank You! The File(s) Is Successfully Uploaded!");
		return  modelViewObj;	
	}
	
	@GetMapping(value = "/getfile")
	public @ResponseBody HttpEntity<byte[]> downloadFileFromDatabase() throws IllegalStateException, IOException {
		System.out.println("Here");
		RowMapper<FileUpload> rowMapper = new FileUploadRowMapper();
		FileUpload filedetail = jdbcTemplate.queryForObject(query1, rowMapper);
		HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "txt"));
        header.set("Content-Disposition", "inline; filename=" + filedetail.getFileName());
        return new HttpEntity<byte[]>(filedetail.getData(), header);
	}
	
}
