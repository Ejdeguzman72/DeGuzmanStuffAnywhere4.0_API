package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.dao.UsersDao;
import com.deguzman.DeGuzmanStuffAnywhere.dto.UserInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

	String GET_ALL_USERS_INFORMATION = "SELECT US.USER_ID, US.EMAIL, US.NAME, US.PASSWORD, US.USERNAME, R.ROLE_DESCR, UST.USER_STATUS_DESCR " + 
			"FROM USERS US, ROLES R, USER_STATUS UST " + 
			"WHERE US.ROLE_ID = R.ROLE_ID and US.USER_STATUS_ID = UST.USER_STATUS_ID";
	
	String GET_USER_INFORMATION_BY_ROLE = "SELECT US.USER_ID, US.EMAIL, US.NAME, US.PASSWORD, US.USERNAME, R.ROLE_DESCR, UST.USER_STATUS_DESCR " + 
			"FROM USERS US, ROLES R, USER_STATUS UST " + 
			"WHERE US.ROLE_ID = R.ROLE_ID and US.USER_STATUS_ID = UST.USER_STATUS_ID" +
			"AND US.ROLE_ID = ?";
	
	String GET_USER_INFORMATION_BY_STATUS = "SELECT US.USER_ID, US.EMAIL, US.NAME, US.PASSWORD, US.USERNAME, R.ROLE_DESCR, UST.USER_STATUS_DESCR " + 
			"FROM USERS US, ROLES R, USER_STATUS UST " + 
			"WHERE US.ROLE_ID = R.ROLE_ID and US.USER_STATUS_ID = UST.USER_STATUS_ID" +
			"AND US.USER_STATUS_ID = ?";
	
	String GET_USER_INFORMATION_BY_ID = "SELECT US.USER_ID, US.EMAIL, US.NAME, US.PASSWORD, US.USERNAME, R.ROLE_DESCR, UST.USER_STATUS_DESCR " + 
			"FROM USERS US, ROLES R, USER_STATUS UST " + 
			"WHERE US.ROLE_ID = R.ROLE_ID and US.USER_STATUS_ID = UST.USER_STATUS_ID" +
			"AND US.USER_ID = ?";
	
	String GET_USER_INFORMATION_BY_USERNAME = "SELECT US.USER_ID, US.EMAIL, US.NAME, US.PASSWORD, US.USERNAME, R.ROLE_DESCR, UST.USER_STATUS_DESCR " + 
			"FROM USERS US, ROLES R, USER_STATUS UST " + 
			"WHERE US.ROLE_ID = R.ROLE_ID and US.USER_STATUS_ID = UST.USER_STATUS_ID" +
			"AND US.USERNAME = ?";
	
	String GET_USER_INFORMATION_BY_NAME = "SELECT US.USER_ID, US.EMAIL, US.NAME, US.PASSWORD, US.USERNAME, R.ROLE_DESCR, UST.USER_STATUS_DESCR " + 
			"FROM USERS US, ROLES R, USER_STATUS UST " + 
			"WHERE US.ROLE_ID = R.ROLE_ID and US.USER_STATUS_ID = UST.USER_STATUS_ID" +
			"AND US.NAME = ?";
	
	String GET_USER_INFORMATION_BY_EMAIL = "SELECT US.USER_ID, US.EMAIL, US.NAME, US.PASSWORD, US.USERNAME, R.ROLE_DESCR, UST.USER_STATUS_DESCR " + 
			"FROM USERS US, ROLES R, USER_STATUS UST " + 
			"WHERE US.ROLE_ID = R.ROLE_ID and US.USER_STATUS_ID = UST.USER_STATUS_ID" +
			"AND US.EMAIL = ?";
	
	String ADD_USER_INFORMATION = "INSERT INTO USERS " + 
			"(EMAIL, NAME, PASSWORD, USERNAME, ROLE_ID, USER_STATUS_ID, AUTO_TRANSACTION_ID, TRANSACTION_ID, MEDICAL_TRANSACTION_ID, EXERCISE_ID, RUN_ID) " + 
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	String UPDATE_USER_INFORMATION = "UPDATE USERS " + 
			"SET EMAIL=?, NAME=?, PASSWORD=?, USERNAME=?, ROLE_ID=?, USER_STATUS_ID=?, AUTO_TRANSACTION_ID=?, TRANSACTION_ID=?, MEDICAL_TRANSACTION_ID=?, EXERCISE_ID=?, RUN_ID=? " + 
			"WHERE user_id=?";
	
	String DELETE_USER_INFORMATION_BY_ID = "DELETE FROM USERS WHERE USER_ID = ?";
	
	String DELETE_ALL_USERS = "DELETE FROM USERS";
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UsersDaoImpl.class);
	
	@Override
	public List<UserInfoDTO> findAllUsersInformation() {
		return jdbcTemplate.query(GET_ALL_USERS_INFORMATION, BeanPropertyRowMapper.newInstance(UserInfoDTO.class));
	}

	@Override
	public List<UserInfoDTO> findAllUsersByRole() {
		List<UserInfoDTO> userListRole = jdbcTemplate.query(GET_USER_INFORMATION_BY_ROLE, (rs,rowNum) -> 
					new UserInfoDTO(
							rs.getInt("USER_ID"),
							rs.getString("USERNAME"),
							rs.getString("PASSWORD"),
							rs.getString("EMAIL"),
							rs.getString("NAME"),
							rs.getString("ROLE_DESCR"),
							rs.getString("USER_STATUS_DESCR")
							));
		
		return userListRole;
	}

	@Override
	public List<UserInfoDTO> findAllUsersByStatus() {
		List<UserInfoDTO> userListStatus = jdbcTemplate.query(GET_USER_INFORMATION_BY_STATUS, (rs,rowNum) -> 
			new UserInfoDTO(
					rs.getInt("USER_ID"),
					rs.getString("USERNAME"),
					rs.getString("PASSWORD"),
					rs.getString("EMAIL"),
					rs.getString("NAME"),
					rs.getString("ROLE_DESCR"),
					rs.getString("USER_STATUS_DESCR")
					));
		
		return userListStatus;
	}

	@Override
	public ResponseEntity<UserInfoDTO> findUserInformationById(@PathVariable long user_id) {
		UserInfoDTO userInfo = jdbcTemplate.queryForObject(GET_USER_INFORMATION_BY_ID, BeanPropertyRowMapper.newInstance(UserInfoDTO.class), user_id);
		LOGGER.info("Retrieved User Information by ID: " + " " + userInfo.getUser_id());
		
		return ResponseEntity.ok().body(userInfo);
	}

	@Override
	public ResponseEntity<UserInfoDTO> findUserInformationByUsername(@PathVariable String username) {
		UserInfoDTO userInfo = jdbcTemplate.queryForObject(GET_USER_INFORMATION_BY_USERNAME, BeanPropertyRowMapper.newInstance(UserInfoDTO.class), username);
		LOGGER.info("Retrieved User Info by username" + " " + userInfo.getUsername());
		
		return ResponseEntity.ok().body(userInfo);
	}

	@Override
	public ResponseEntity<UserInfoDTO> findUserInformationByName(@PathVariable String name) {
		UserInfoDTO userInfo = jdbcTemplate.queryForObject(GET_USER_INFORMATION_BY_NAME, BeanPropertyRowMapper.newInstance(UserInfoDTO.class), name);
		LOGGER.info("Retrieved User Info by name" + " " + userInfo.getName());
		
		return ResponseEntity.ok().body(userInfo);
	}

	@Override
	public ResponseEntity<UserInfoDTO> findUserInformationByEmail(@PathVariable String email) {
		UserInfoDTO userInfo = jdbcTemplate.queryForObject(GET_USER_INFORMATION_BY_EMAIL, BeanPropertyRowMapper.newInstance(UserInfoDTO.class), email);
		LOGGER.info("Retrieved User Info by email" + " " + userInfo.getEmail());
		
		return ResponseEntity.ok().body(userInfo);
	}

	@Override
	public int addUserInformation(Users user) {
		
		String username = user.getUsername();
		String password = user.getPassword();
		String name = user.getName();
		String email = user.getEmail();
		int role = user.getRole_id();
		int user_status = user.getUser_status_id();
		long autoTransaction = user.getAuto_transaction_id();
		long transaction = user.getTransaction_id();
		long medicalTransaction = user.getMedical_transaction_id();
		int exericse = user.getExercise_id();
		long run = user.getRun_id();
		
		return jdbcTemplate.update(ADD_USER_INFORMATION, new Object[] {
			username, 
			password, 
			name, 
			email, 
			role, 
			user_status, 
			autoTransaction, 
			transaction, 
			medicalTransaction, 
			exericse, 
			run	
		});
	}

	@Override
	public int updateUserInformation(long user_id, Users user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUserInformationById(long user_id) {
		return jdbcTemplate.update(DELETE_USER_INFORMATION_BY_ID, user_id);
	}

	@Override
	public int deleteAllUserInformation() {
		return jdbcTemplate.update(DELETE_ALL_USERS);
	}

}
