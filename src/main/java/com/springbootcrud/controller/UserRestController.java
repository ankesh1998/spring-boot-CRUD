package com.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.user.pojo.User;
import com.springbootcrud.userdao.UserDao;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserDao dao;

	@GetMapping
	public List<User> getAllUser() {
		return dao.getAllUser();
	}

	@GetMapping("/{user_id}")
	public User getUserById(@PathVariable("user_id") int id) {
		return dao.getUserById(id);
	}

	@DeleteMapping("/{user_id}")
	public String deleteUser(@PathVariable("user_id") int id) {
		dao.deleteUser(id);
		return "record deleted successfully";
	}

	@PostMapping
	public String addUser(@RequestBody User user) {
		dao.createUser(user);
		return "record inserted successfully";
	}

	@PutMapping
	public String editUser(@RequestBody User user) {
		dao.editUser(user);
		return "record updated successfully";
	}
}
