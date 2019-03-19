/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.nw.onboarding.dao.FileUploadDAO;

/**
 * @author 656579
 *
 */
public class FileUploadDAOImpl implements FileUploadDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
}
