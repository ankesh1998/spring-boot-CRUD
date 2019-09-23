package com.springbootcrud.userdao;

import java.util.List;

import com.springbootcrud.user.pojo.User;

public interface UserDao {

	public int createUser(User user);

	public List<User> getAllUser();

	public int deleteUser(int user_id);

	public void editUser(User user);

	public User getUserById(int user_id);
}
