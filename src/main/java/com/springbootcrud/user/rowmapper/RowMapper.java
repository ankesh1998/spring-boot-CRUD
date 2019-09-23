package com.springbootcrud.user.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.springbootcrud.user.pojo.User;

public class RowMapper implements org.springframework.jdbc.core.RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUser_id(rs.getInt(1));
		user.setUser_name(rs.getString(2));
		user.setUser_email(rs.getString(3));
		user.setUser_contact(rs.getString(4));

		return user;
	}
}
