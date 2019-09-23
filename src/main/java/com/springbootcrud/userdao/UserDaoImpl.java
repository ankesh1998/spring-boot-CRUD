package com.springbootcrud.userdao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbootcrud.user.pojo.User;
import com.springbootcrud.user.rowmapper.RowMapper;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int createUser(User user) {

		return jdbcTemplate.update("Insert into user (user_name,user_email,user_contact) values (?,?,?)",
				user.getUser_name(), user.getUser_email(), user.getUser_contact());
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
		jdbcTemplate.update(sql, user.getUser_name(), user.getUser_email(), user.getUser_contact(), user.getUser_id());
	}

	@Override
	public User getUserById(int user_id) {
		String sql = "select user_id,user_name,user_email,user_contact from user where user_id=?";
		RowMapper rowMapper = new RowMapper();
		User user = jdbcTemplate.queryForObject(sql, rowMapper, user_id);
		return user;
	}

}
