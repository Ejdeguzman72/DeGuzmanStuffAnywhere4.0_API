package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.User;
import com.deguzman.DeGuzmanStuffAnywhere.service.UserService;

@RestController
@RequestMapping("/app/users")
@CrossOrigin
public class UsersController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<User> getAllUserInformation() {
		return userService.findAllUsersInformation();
	}
}
