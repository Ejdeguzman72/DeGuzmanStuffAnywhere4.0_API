package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dao.RestaurantDao;
import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

@Repository
public class RestaurantDaoImpl implements RestaurantDao {

	String GET_ALL_RESTAURANT_INFORMATION = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT " + "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "ORDER BY R.NAME";

	String GET_RESTAURANT_INFORMATION_BY_TYPE = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT " + "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND RT.RESTAURANT_TYPE_ID = ? " + "ORDER BY R.NAME";

	String GET_RESTAURANT_INFORMATION_DTO_BY_ID = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT " + "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND RESTAURANT_ID = ?";
	
	String GET_RESTAURANT_INFO_BY_ID = "SELECT * FROM RESTAURANT WHERE RESTAURANT_ID = ?";

	String GET_RESTAURANT_INFORMATION_BY_ZIP = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT " + "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND ZIP = ? " + "ORDER BY R.NAME";

	String GET_RESTAURANT_INFORMATION_BY_DESCR = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT " + "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND DESCR = ? " + "ORDER BY R.NAME";

	String GET_RESTAURANT_INFORMATION_BY_NAME = "SELECT R.RESTAURANT_ID, R.NAME, R.ADDRESS, R.CITY, R.STATE, R.ZIP, RT.DESCR "
			+ "FROM RESTAURANT R, RESTAURANT_TYPE RT " + "WHERE R.RESTAURANT_TYPE_ID  = RT.RESTAURANT_TYPE_ID "
			+ "AND NAME = ?";

	String GET_RESTAURANT_COUNT = "SELECT COUNT(*) FROM RESTAURANT";

	String ADD_RESTAURANT_INFORMATION = "INSERT INTO RESTAURANT "
			+ "(NAME, ADDRESS, CITY, STATE, ZIP, RESTAURANT_TYPE_ID) " + "VALUES(?, ?, ?, ?, ?, ?)";
	
	String UPDATE_RESTAURANT_INFORMATION = "UPDATE RESTAURANT "
			+ "SET NAME = ?, "
			+ "ADDRESS = ?, "
			+ "CITY = ?, "
			+ "STATE = ?, "
			+ "ZIP = ?, "
			+ "RESTAURANT_TYPE_ID = ? "
			+ "WHERE RESTAURANT_ID = ?";

	String DELETE_RESTAURANT_INFORMATION_BY_ID = "DELETE FROM RESTAURANT WHERE RESTAURANT_ID = ?";

	String DELETE_ALL_RESTAURANT_INFORMATION = "DELETE FROM RESTAURANT";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantDaoImpl.class);

	@Override
	@Cacheable(value = "restaurantList")
	public List<RestaurantInfoDTO> findAllRestaurants() {
		List<RestaurantInfoDTO> restaurantList = jdbcTemplate.query(GET_ALL_RESTAURANT_INFORMATION,
				BeanPropertyRowMapper.newInstance(RestaurantInfoDTO.class));

		LOGGER.info("Retrieving all restaurant information...");

		return restaurantList;
	}

	@Override
	public List<RestaurantInfoDTO> findAllRestaurantsByType(int restaurant_type_id) {
		List<RestaurantInfoDTO> restaurantListType = jdbcTemplate.query(GET_RESTAURANT_INFORMATION_BY_TYPE,
				(rs, rowNum) -> new RestaurantInfoDTO(rs.getInt("RESTAURANT_ID"), rs.getString("NAME"),
						rs.getString("ADDRESS"), rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"),
						rs.getString("DESCR")),
				restaurant_type_id);

		LOGGER.info("Retrieving Restaurant information by restaurant_type_id: " + restaurant_type_id);

		return restaurantListType;
	}

	@Override
	@Cacheable(value = "restaurantById", key = "#restaurant_id")
	public RestaurantInfoDTO findRestaurantById(int restaurant_id) throws InvalidRestaurantException {
		RestaurantInfoDTO restaurantInfo = jdbcTemplate.queryForObject(GET_RESTAURANT_INFORMATION_DTO_BY_ID,
				BeanPropertyRowMapper.newInstance(RestaurantInfoDTO.class), restaurant_id);

		LOGGER.info("Retrieved Restaurant Information: " + " " + restaurantInfo.getName());

		return restaurantInfo;
	}
	
	public Restaurant findRestaurantInfoById(@PathVariable int restaurant_id) {
		Restaurant restaurant = jdbcTemplate.queryForObject(GET_RESTAURANT_INFO_BY_ID , BeanPropertyRowMapper.newInstance(Restaurant.class), restaurant_id);
		
		LOGGER.info("Retrieved Restaurant Information: " + " " + restaurant.getName());
		
		return restaurant;
	}

	@Override
	public List<RestaurantInfoDTO> findRestaurantsByZipCode(String zip) {
		List<RestaurantInfoDTO> restaurantListZipcode = jdbcTemplate.query(GET_RESTAURANT_INFORMATION_BY_ZIP,
				(rs, rowNum) -> new RestaurantInfoDTO(rs.getInt("RESTAURANT_ID"), rs.getString("NAME"),
						rs.getString("ADDRESS"), rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"),
						rs.getString("DESCR")),
				zip);

		LOGGER.info("Searching for restaurants based off zip: " + zip);

		return restaurantListZipcode;
	}

	@Override
	public List<RestaurantInfoDTO> findRestaurantsByDescr(String descr) {
		List<RestaurantInfoDTO> restaurantListDescr = jdbcTemplate.query(GET_RESTAURANT_INFORMATION_BY_DESCR,
				(rs, rowNum) -> new RestaurantInfoDTO(rs.getInt("RESTAURANT_ID"), rs.getString("NAME"),
						rs.getString("ADDRESS"), rs.getString("CITY"), rs.getString("STATE"), rs.getString("ZIP"),
						rs.getString("DESCR")),
				descr);

		LOGGER.info("Searching restaurants based off restaurant type: " + " " + descr);

		return restaurantListDescr;
	}

	@Override
	public RestaurantInfoDTO findRestaurantByName(String name) {
		RestaurantInfoDTO restaurant = jdbcTemplate.queryForObject(GET_RESTAURANT_INFORMATION_BY_NAME,
				BeanPropertyRowMapper.newInstance(RestaurantInfoDTO.class), name);

		LOGGER.info("Retrieved Restaurant Information: " + " " + restaurant.getName());

		return restaurant;
	}

	@Override
	public long getRestaurantCount() {
		long count = jdbcTemplate.queryForObject(GET_RESTAURANT_COUNT, Integer.class);

		LOGGER.info("Getting Restaurant Count...");

		return count;
	}

	@Override
	@CachePut(value = "restaurantList")
	public int addRestaurantInformation(@RequestBody Restaurant restaurant) throws ResourceNotFoundException, DuplicateRestaurantException {

		String name = restaurant.getName();
		
		if (checkRestaurantNames(name)) {
			throw new DuplicateRestaurantException("Restaurant Already Exists");
		}
		
		String address = restaurant.getAddress();
		String city = restaurant.getCity();
		String state = restaurant.getState();
		String zip = restaurant.getZip();
		int restaurant_type_id = restaurant.getRestaurant_type_id();

		LOGGER.info("Adding Restaurant Information: " + name);

		return jdbcTemplate.update(ADD_RESTAURANT_INFORMATION,
				new Object[] { name, address, city, state, zip, restaurant_type_id });
	}

	@Override
	@CachePut(value = "restaurantById", key = "#restaurant_id")
	public int updateRestaurantInformation(int restaurant_id, Restaurant restaurantDetails)
			throws ResourceNotFoundException {

		int result = 0;
		
		Restaurant restaurant = jdbcTemplate.queryForObject(GET_RESTAURANT_INFORMATION_DTO_BY_ID,
				BeanPropertyRowMapper.newInstance(Restaurant.class), restaurant_id);
		
		if (restaurant != null) {
			restaurant.setName(restaurantDetails.getName());
			restaurant.setAddress(restaurantDetails.getAddress());
			restaurant.setCity(restaurantDetails.getCity());
			restaurant.setState(restaurantDetails.getState());
			restaurant.setZip(restaurantDetails.getZip());
			restaurant.setRestaurant_type_id(restaurantDetails.getRestaurant_type_id());
			restaurant.setRestaurant_id(restaurant_id);
			
			result = jdbcTemplate.update(UPDATE_RESTAURANT_INFORMATION, new Object[] {
				restaurant.getName(),
				restaurant.getAddress(),
				restaurant.getCity(),
				restaurant.getState(),
				restaurant.getZip(),
				restaurant.getRestaurant_type_id(),
				restaurant.getRestaurant_id()
			});
			
			LOGGER.info("Updating restaurant info for restaurant_id: " + restaurant_id);
		}
		
		return result;
	}

	@Override
	@CachePut(value = "restaurantById", key = "#restaurant_id")
	public int deleteRestaurantInformation(int restaurant_id) {
		int count = jdbcTemplate.update(DELETE_RESTAURANT_INFORMATION_BY_ID, restaurant_id);

		LOGGER.info("Deleting Restaurat Information by restaurant_id: " + restaurant_id);

		return count;
	}

	@Override
	@CachePut(value = "restaurantList")
	public int deleteAllRestaurantInformation() {
		int count = jdbcTemplate.update(DELETE_ALL_RESTAURANT_INFORMATION);

		LOGGER.info("Deleting All Restaurants...");

		return count;
	}
	
	public boolean checkRestaurantNames(String name) {

		List<RestaurantInfoDTO> bookList = findAllRestaurants();
		List<String> namesList;
		boolean result = false;

		namesList = bookList.stream().map(RestaurantInfoDTO::getName).collect(Collectors.toList());

		if (namesList.contains(name)) {
			result = true;
		}

		return result;
	}

}
