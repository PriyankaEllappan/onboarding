/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import java.sql.CallableStatement;
import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.MailAttachmentDAO;
import com.cts.nw.onboarding.exception.CustomException;
import com.cts.nw.onboarding.mappers.FileUploadRowMapper;

/**
 * @author 656579
 *
 */
@Transactional
@Repository
public class MailAttachmentDAOImpl implements MailAttachmentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public MailAttachment downloadAttachment(String id) throws CustomException {
		try {
			String whereClause = "WHERE ID = ?";
			String query = QueryConstants.MAILATTACHMENT_SELECT + whereClause;
			RowMapper<MailAttachment> rowMapper = new FileUploadRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch(Exception e){
			throw new CustomException(e.getMessage());
		}

	}

	@Override
	public Integer uploadAttachmentViaCallable(MailAttachment mailAttachment) throws CustomException {
		Integer returnValue = null;
		try {
			CallableStatement cstmt = jdbcTemplate.getDataSource().getConnection()
					.prepareCall(QueryConstants.MAILPROCEDURE_INSERT);
			cstmt.setString(2, mailAttachment.getFileName());
			cstmt.setBytes(3, mailAttachment.getData());
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			returnValue = cstmt.getInt(1);
		} catch(Exception e){
			throw new CustomException(e.getMessage());
		}
		return returnValue;
	}

}
