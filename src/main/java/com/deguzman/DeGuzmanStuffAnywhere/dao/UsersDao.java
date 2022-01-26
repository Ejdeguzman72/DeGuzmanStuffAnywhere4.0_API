package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.UserInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Users;

public interface UsersDao {

	public List<UserInfoDTO> findAllUsersInformation();
	
	public List<UserInfoDTO> findAllUsersByRole(@PathVariable int role_id);
	
	public List<UserInfoDTO> findAllUsersByStatus(@PathVariable int user_status_id);
	
	public ResponseEntity<UserInfoDTO> findUserInformationById(@PathVariable long user_id);
	
	public ResponseEntity<UserInfoDTO> findUserInformationByUsername(@PathVariable String username);
	
	public ResponseEntity<UserInfoDTO> findUserInformationByName(@PathVariable String name);
	
	public ResponseEntity<UserInfoDTO> findUserInformationByEmail(@PathVariable String email);
	
	public int addUserInformation(@RequestBody Users user);
	
	public int updateUserInformation(@PathVariable long user_id, @RequestBody Users user);
	
	public int deleteUserInformationById(@PathVariable long user_id);
	
	public int deleteAllUserInformation();
}
