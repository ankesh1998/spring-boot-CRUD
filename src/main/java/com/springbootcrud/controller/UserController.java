package com.springbootcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootcrud.user.pojo.User;
import com.springbootcrud.userdao.UserDao;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;

	@Autowired
//	private EmailUtil emailUtil;

	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@RequestMapping(value = "userRegistration", method = RequestMethod.POST)
	public String showRegisterPage(@ModelAttribute User user, Model model) {
//		System.out.println("i m in controller");
		if (user.getUser_email() == "") {
			user.setUser_email(null);
		}
		dao.createUser(user);
		model.addAttribute("result", "Record inserted Successfully");
//		emailUtil.sendEmail(user.getUser_email(), "Admin Msg",
//				"Welcome to SpringbOOT, you got successfully registered onto our website.");
		return "index";
	}

	@RequestMapping("allUser")
	public String getAllUser(Model model) {
		List<User> allUser = dao.getAllUser();
		model.addAttribute("allUser", allUser);
		return "allUser";
	}

	@RequestMapping("/delete_user")
	public String deleteUser(@RequestParam("Id") int user_id, Model model) {
		dao.deleteUser(user_id);
		List<User> allUser = dao.getAllUser();
		model.addAttribute("allUser", allUser);
		model.addAttribute("result", "Record Deleted Successfully");
		return "allUser";
	}

	@RequestMapping("/edit_user")
	public String showEditUser(@RequestParam("Id") int user_id, Model model) {
		User user = dao.getUserById(user_id);
		model.addAttribute("user", user);
		return "edit_user";
	}

	@RequestMapping(value = "/processEditUser", method = RequestMethod.POST)
	public String editUser(@ModelAttribute User user, ModelMap model) {
		if (user.getUser_email() == "") {
			user.setUser_email(null);
		}
		dao.editUser(user);
		List<User> allUser = dao.getAllUser();
		model.addAttribute("allUser", allUser);
		model.addAttribute("result", "User Updated Successfully");
		return "allUser";
	}

}
