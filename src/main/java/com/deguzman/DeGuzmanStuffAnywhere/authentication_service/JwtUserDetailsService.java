package com.deguzman.DeGuzmanStuffAnywhere.authentication_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.UserAuthenticationDao;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.UsernameException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Users;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = Logger.getLogger(JwtUserDetailsService.class);

	@Autowired
	private UserAuthenticationDao userAuthenticationDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	public static Date date = new Date();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userAuthenticationDao.findUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		User activeUser = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
		
		return activeUser;
	}
	
	public Users checkingLoggingInUser(String username) {
		Users userLoggingIn = userAuthenticationDao.findUserByUsername(username);
		return userLoggingIn;
	}
	
	public boolean getAllUsernames(String username) {
		
		List<Users> usersList = userAuthenticationDao.findAll();
		List<String> usernameList;
		boolean result = false;
		 
		usernameList = usersList.stream().map(Users::getUsername).collect(Collectors.toList());
		
		if (usernameList.contains(username)) {
			result = true;
		}
		
		return result;
	}
	
	public Users save(Users user) throws ResourceNotFoundException, UsernameException {
		Users newUser = new Users();
		
		String username = user.getUsername();
		
		if (getAllUsernames(username)) {
			throw new UsernameException("Username Exists already!");
		} 
		
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		
		
		if (newUser.username == null
				|| newUser.password == null
				// || newUser.role_id == 0
				//|| newUser.user_status_id == 0
				) {
			LOGGER.warn(String.format("User is null/incorrect entries"));
		} else {
			LOGGER.info(String.format("User has been saved: " + newUser.username));
		}
		return userRepository.save(newUser);
	}
	
	public void checkUserinDB(String username) throws UsernameException {
		List<Users> usersList = userRepository.findAll();
		
		if (usersList.contains(username)) {
			throw new UsernameException("Username already exists");
		}
	}
}
