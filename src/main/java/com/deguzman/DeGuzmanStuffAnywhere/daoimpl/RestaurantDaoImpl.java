package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dao.RestaurantDao;
import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

	String GET_ALL_RESTAURANT_INFORMATION = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT "
			+ "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID";
	
	String GET_RESTAURANT_INFORMATION_BY_TYPE = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT "
			+ "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND RT.RESTAURANT_TYPE_ID = ?";
	
	String GET_RESTAURANT_INFORMATION_BY_ID = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT "
			+ "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND RESTAURANT_ID = ?";
	
	String GET_RESTAURANT_INFORMATION_BY_ZIP = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT "
			+ "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND ZIP = ?";
	
	String GET_RESTAURANT_INFORMATION_BY_DESCR = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR " + 
						"FROM RESTAURANT R, RESTAURANT_TYPE RT " + 
						"WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID " + 
						"AND DESCR = ?";
	
	String GET_RESTAURANT_INFORMATION_BY_NAME = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR " + 
			"FROM RESTAURANT R, RESTAURANT_TYPE RT " + 
			"WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID " + 
			"AND NAME = ?";
	
	String GET_RESTAURANT_COUNT = "SELECT COUNT(*) FROM RESTAURANT";
	
	String ADD_RESTAURANT_INFORMATION = "INSERT INTO RESTAURANT " + 
			"(ADDRESS, CITY, NAME, STATE, ZIP, RESTAURANT_TYPE_ID) " + 
			"VALUES(?, ?, ?, ?, ?, ?)"; 
	
	String DELETE_RESTAURANT_INFORMATION_BY_ID = "DELETE FROM RESTAURANT WHERE RESTAURANT_ID = ?";
	
	String DELETE_ALL_RESTAURANT_INFORMATION = "DELTE FROM RESTAURANT";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantDaoImpl.class);
	
	@Override
	public List<RestaurantInfoDTO> findAllRestaurants() {
		return jdbcTemplate.query(GET_ALL_RESTAURANT_INFORMATION, BeanPropertyRowMapper.newInstance(RestaurantInfoDTO.class));
	}
	
	@Override
	public List<RestaurantInfoDTO> findAllRestaurantsByType(int restaurant_type_id) {
		return jdbcTemplate.query(GET_RESTAURANT_INFORMATION_BY_TYPE, (rs, rowNum) -> 
				new RestaurantInfoDTO(
						rs.getInt("RESTAURANT_ID"),
						rs.getString("NAME"),
						rs.getString("ADDRESS"),
						rs.getString("CITY"),
						rs.getString("STATE"),
						rs.getString("ZIP"),
						rs.getString("DESCR")
						), restaurant_type_id);
	}

	@Override
	public ResponseEntity<RestaurantInfoDTO> findRestaurantById(int restaurant_id) throws InvalidRestaurantException {
		RestaurantInfoDTO restaurantInfo = jdbcTemplate.queryForObject(GET_RESTAURANT_INFORMATION_BY_ID, BeanPropertyRowMapper.newInstance(RestaurantInfoDTO.class), restaurant_id);
		LOGGER.info("Retrieved Restaurant Information: " + " " + restaurantInfo.getName());
		
		return ResponseEntity.ok().body(restaurantInfo);
	}
	
	@Override
	public List<RestaurantInfoDTO> findRestaurantsByZipCode(String zip) {
		List<RestaurantInfoDTO> restaurantListZipcode = jdbcTemplate.query(GET_RESTAURANT_INFORMATION_BY_ZIP, (rs, rowNum) -> 
				new RestaurantInfoDTO(
							rs.getInt("RESTAURANT_ID"),
							rs.getString("NAME"),
							rs.getString("ADDRESS"),
							rs.getString("CITY"),
							rs.getString("STATE"),
							rs.getString("ZIP"),
							rs.getString("DESCR")
						), zip);
		
		LOGGER.info("Searching for restaurants based off zip: " + zip);
		
		return restaurantListZipcode;
	}

	@Override
	public List<RestaurantInfoDTO> findRestaurantsByDescr(String descr) {
		List<RestaurantInfoDTO> restaurantListDescr = jdbcTemplate.query(GET_RESTAURANT_INFORMATION_BY_DESCR, (rs, rowNum) ->
			new RestaurantInfoDTO(
					rs.getInt("RESTAURANT_ID"),
					rs.getString("NAME"),
					rs.getString("ADDRESS"),
					rs.getString("CITY"),
					rs.getString("STATE"),
					rs.getString("ZIP"),
					rs.getString("DESCR")
					), descr);
		LOGGER.info("Searching restaurants based off restaurant type: " + " " + descr);
		
		return restaurantListDescr;
	}

	@Override
	public ResponseEntity<RestaurantInfoDTO> findRestaurantByName(String name) {
		RestaurantInfoDTO restaurant = jdbcTemplate.queryForObject(GET_RESTAURANT_INFORMATION_BY_NAME, BeanPropertyRowMapper.newInstance(RestaurantInfoDTO.class), name);
		LOGGER.info("Retrieved Restaurant Information: " + " " + restaurant.getName());
		
		return ResponseEntity.ok().body(restaurant);
	}

	@Override
	public long getRestaurantCount() {
		return jdbcTemplate.queryForObject(GET_RESTAURANT_COUNT, Integer.class);
	}

	@Override
	public int addRestaurantInformation(@RequestBody Restaurant restaurant) throws ResourceNotFoundException {
		
		String name = restaurant.getName();
		String address = restaurant.getAddress();
		String city = restaurant.getCity();
		String state = restaurant.getState();
		String zip = restaurant.getZip();
		int restaurant_type_id = restaurant.getRestaurant_type_id();
		
		return jdbcTemplate.update(ADD_RESTAURANT_INFORMATION, new Object[] {
				name,
				address,
				city,
				state,
				zip,
				restaurant_type_id
		});
	}

	@Override
	public int updateRestaurantInformation(int restaurantid, Restaurant restaurantDetails)
			throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteRestaurantInformation(int restaurant_id) {
		return jdbcTemplate.update(DELETE_RESTAURANT_INFORMATION_BY_ID, restaurant_id);
	}

	@Override
	public int deleteAllRestaurantInformation() {
		return jdbcTemplate.update(DELETE_ALL_RESTAURANT_INFORMATION);
	}

}
