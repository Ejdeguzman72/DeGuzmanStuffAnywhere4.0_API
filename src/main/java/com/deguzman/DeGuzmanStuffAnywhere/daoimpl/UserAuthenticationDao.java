package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.model.Users;

@Repository
public interface UserAuthenticationDao extends JpaRepository<Users,Long> {

	Users findUserByUsername(String username);
	List<Users> findAll();
}
