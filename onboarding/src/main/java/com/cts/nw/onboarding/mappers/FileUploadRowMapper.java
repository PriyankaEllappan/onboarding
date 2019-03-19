/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.MailAttachment;

/**
 * @author 656579
 *
 */
public class FileUploadRowMapper implements RowMapper<MailAttachment> {

	@Override
	public MailAttachment mapRow(ResultSet rs, int rowNum) throws SQLException {
		MailAttachment file = new MailAttachment();
		file.setId(rs.getInt("ID"));
		file.setFileName(rs.getString("FILENAME"));
		file.setData(rs.getBytes("FILEDATA"));
		return file;
		
	}

}