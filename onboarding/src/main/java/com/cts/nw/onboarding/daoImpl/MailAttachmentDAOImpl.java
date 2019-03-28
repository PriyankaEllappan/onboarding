/**
 * 
 */
package com.cts.nw.onboarding.daoImpl;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.nw.onboarding.bo.MailAttachment;
import com.cts.nw.onboarding.constants.QueryConstants;
import com.cts.nw.onboarding.dao.MailAttachmentDAO;
import com.cts.nw.onboarding.exception.GlobalExceptionHandler;
import com.cts.nw.onboarding.mappers.FileUploadRowMapper;

/**
 * @author 656579
 *
 */
@Transactional
@Repository
public class MailAttachmentDAOImpl implements MailAttachmentDAO {
	
	Logger log = Logger.getLogger(MailAttachmentDAOImpl.class) ;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public MailAttachment downloadAttachment(String id) {
		try {
			String whereClause = "WHERE ID = ?";
			String query = QueryConstants.MAILATTACHMENT_SELECT + whereClause;
			RowMapper<MailAttachment> rowMapper = new FileUploadRowMapper();
			return this.jdbcTemplate.queryForObject(query, rowMapper, id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public Integer uploadAttachmentViaCallable(MailAttachment mailAttachment) {
		Integer returnValue = null;
		try {
			CallableStatement cstmt = jdbcTemplate.getDataSource().getConnection()
					.prepareCall(QueryConstants.MAILPROCEDURE_INSERT);
			cstmt.setString(2, mailAttachment.getFileName());
			cstmt.setBytes(3, mailAttachment.getData());
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.execute();
			returnValue = cstmt.getInt(1);
		} catch (SQLException e) {
			new GlobalExceptionHandler().handleSQLException(e);
		} catch (Exception e) {
			log.error(e.getCause());
			e.printStackTrace();
		}
		return returnValue;
	}

}
