package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.UsersDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.UserInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Users;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/users")
@CrossOrigin
public class UsersController {

	@Autowired
	private UsersDaoImpl usersDaoImpl;
	
	@GetMapping("/all")
	public List<UserInfoDTO> getAllUserInformation() {
		return usersDaoImpl.findAllUsersInformation();
	}
	
	@GetMapping("/all/role")
	public List<UserInfoDTO> getAllUsersByRole() {
		return usersDaoImpl.findAllUsersByRole();
	}
	
	@GetMapping("/all/status")
	public List<UserInfoDTO> getAllUsersByStatus() {
		return usersDaoImpl.findAllUsersByStatus();
	}
	
	@GetMapping("/user/{user_id}")
	public ResponseEntity<UserInfoDTO> getUserInformationById(@PathVariable long user_id) {
		return usersDaoImpl.findUserInformationById(user_id);
	}
	
	@GetMapping("/user/username/{username}")
	public ResponseEntity<UserInfoDTO> getUserInformationByUsername(@PathVariable String username) {
		return usersDaoImpl.findUserInformationByUsername(username);
	}
	
	@GetMapping("/user/name/{name}")
	public ResponseEntity<UserInfoDTO> getUserInformationByName(@PathVariable String name) {
		return usersDaoImpl.findUserInformationByName(name);
	}
	
	@GetMapping("/user/email/{email}")
	public ResponseEntity<UserInfoDTO> getUserInformationByEmail(@PathVariable String email) {
		return usersDaoImpl.findUserInformationByEmail(email);
	}
	
	@PostMapping("/add-user-information")
	public int addUserInformation(@RequestBody Users user) {
		return usersDaoImpl.addUserInformation(user);
	}
	
	@DeleteMapping("/user/{user_id}")
	public int deleteUserInformationById(@PathVariable long user_id) {
		return usersDaoImpl.deleteUserInformationById(user_id);
	}
	
	@DeleteMapping("delete-all-users")
	public int deleteAllUserInformation() {
		return usersDaoImpl.deleteAllUserInformation();
	}
}
