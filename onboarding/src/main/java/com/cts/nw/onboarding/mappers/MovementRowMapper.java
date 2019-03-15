/**
 * 
 */
package com.cts.nw.onboarding.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.nw.onboarding.bo.Movement;

/**
 * @author 616550
 *
 */

public class MovementRowMapper implements RowMapper<Movement> {

	@Override
	public Movement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Movement movement = new Movement();
		movement.setId(rs.getInt("ID"));
		movement.setMovement(rs.getString("MOVEMENT"));
		return movement;
		
	}

}