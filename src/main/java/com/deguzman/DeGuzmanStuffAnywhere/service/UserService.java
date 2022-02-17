package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.User;
import com.deguzman.DeGuzmanStuffAnywhere.authentication_repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAllUsersInformation() {
		return userRepository.findAll();
	}
}
