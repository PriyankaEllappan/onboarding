/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.FileUpload;

/**
 * @author 656579
 *
 */
public class FileUploadRowMapper implements RowMapper<FileUpload> {

	@Override
	public FileUpload mapRow(ResultSet rs, int rowNum) throws SQLException {
		FileUpload file = new FileUpload();
		file.setId(rs.getInt("ID"));
		file.setFileName(rs.getString("FILENAME"));
		file.setData(rs.getBytes("FILEDATA"));
		return file;
		
	}

}