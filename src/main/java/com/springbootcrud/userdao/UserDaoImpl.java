package com.springbootcrud.userdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.springbootcrud.exception.DuplicateEntryException;
import com.springbootcrud.user.pojo.User;
import com.springbootcrud.user.rowmapper.RowMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createUser(User user) {

		try {
			jdbcTemplate.update("Insert into user (user_name,user_email,user_contact) values (?,?,?)",
					user.getUser_name(), user.getUser_email(), user.getUser_contact());
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateEntryException("Either the e-mail or contact already exists in Database.");
		}
	}

	@Override
	public List<User> getAllUser() {
		String sql = "select user_id,user_name,user_email,user_contact from user";
		RowMapper rowMapper = new RowMapper();
		List<User> allUser = jdbcTemplate.query(sql, rowMapper);
		return allUser;
	}

	@Override
	public int deleteUser(int user_id) {
		String sql = "delete from user where user_id = ?";
		return jdbcTemplate.update(sql, user_id);

	}

	@Override
	public void editUser(User user) {
		String sql = "Update user set user_name=?,user_email=?,user_contact=? where user_id=?";

		try {
			jdbcTemplate.update(sql, user.getUser_name(), user.getUser_email(), user.getUser_contact(),
					user.getUser_id());
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateEntryException("Either the e-mail or contact already exists in Database.");
		}
	}

	@Override
	public boolean validateEmail(String user_email) {
		String sql = "SELECT count(*) FROM user WHERE user_email = ?";
		boolean result = false;
		int count = jdbcTemplate.queryForObject(sql, new Object[] { user_email }, Integer.class);
		if (count > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean validateContact(String user_contact) {
		String sql = "SELECT count(*) FROM user WHERE user_contact = ?";
		boolean result = false;
		int count = jdbcTemplate.queryForObject(sql, new Object[] { user_contact }, Integer.class);
		if (count > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public User getUserById(int user_id) {
		String sql = "select user_id,user_name,user_email,user_contact from user where user_id=?";
		User user = jdbcTemplate.query(sql, new Object[] { user_id }, new ResultSetExtractor<User>() {

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				User user = new User();
				while (rs.next()) {
					user.setUser_id(rs.getInt(1));
					user.setUser_name(rs.getString(2));
					user.setUser_email(rs.getString(3));
					user.setUser_contact(rs.getString(4));

				}
				return user;
			}
		});

		return user;
	}
}
