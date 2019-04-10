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
		file.setOnboardFileName(rs.getString("ONBOARDFILENAME"));
		file.setOnboardData(rs.getBytes("ONBOARDFILEDATA"));
		file.setOffboardFileName(rs.getString("OFFBOARDFILENAME"));
		file.setOffboardData(rs.getBytes("OFFBOARDFILEDATA"));
		return file;
	}

}