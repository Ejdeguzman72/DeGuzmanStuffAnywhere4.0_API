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

import com.deguzman.DeGuzmanStuffAnywhere.dao.RestaurantTypeDao;
import com.deguzman.DeGuzmanStuffAnywhere.model.RestaurantType;

@Repository
public class RestaurantTypeDaoImpl implements RestaurantTypeDao {

	String GET_ALL_RESTAURANT_TYPES = "SELECT * FROM RESTAURANT_TYPE";
	String GET_RESTAURANT_INFORMATION_BY_ID = "SELECT * FROM RESTAURANT_TYPE WHERE RESTAURANT_TYPE_ID = ?";
	String GET_RESTAURANT_INFORMATION_BY_DESCR = "SELECT * FROM RESTAURANT_TYPE WHERE DESCR = ?";
	String GET_RESTAURANT_TYPE_ID_BY_DESCR = "SELECT RESTAURANT_TYPE_ID FROM RESTAURANT_TYPE WHERE DESCR = ?";
	String GET_RESTAURANT_TYPE_COUNT = "SELECT COUNT(*) FROM RESTAURANT_TYPE";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantTypeDaoImpl.class);

	@Override
	public List<RestaurantType> findAllRestaurantTypeInformation() {
		List<RestaurantType> list = jdbcTemplate.query(GET_ALL_RESTAURANT_TYPES,
				BeanPropertyRowMapper.newInstance(RestaurantType.class));

		LOGGER.info("Retrieving all restaurant type information...");

		return list;
	}

	@Override
	public ResponseEntity<RestaurantType> findRestaurantInformationById(@PathVariable int restaurant_type_id) {
		RestaurantType type = jdbcTemplate.queryForObject(GET_RESTAURANT_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(RestaurantType.class), restaurant_type_id);

		LOGGER.info("Getting restaurant type by ID: " + restaurant_type_id);

		return ResponseEntity.ok().body(type);
	}

	@Override
	public ResponseEntity<RestaurantType> findRestaurantTypeByDescr(String descr) {
		RestaurantType type = jdbcTemplate.queryForObject(GET_RESTAURANT_INFORMATION_BY_DESCR,
				BeanPropertyRowMapper.newInstance(RestaurantType.class), descr);

		LOGGER.info("Getting restaurant type by Descr: " + descr);

		return ResponseEntity.ok().body(type);
	}

	@Override
	public long getRestaurantTypeCount() {
		long count = jdbcTemplate.queryForObject(GET_RESTAURANT_TYPE_COUNT, Integer.class);

		LOGGER.info("Getting restaurant type count");

		return count;
	}

	public int retrieveTypeId(@PathVariable String descr) {
		int id = jdbcTemplate.queryForObject(GET_RESTAURANT_TYPE_ID_BY_DESCR, Integer.class);

		LOGGER.info("Retrieving restaurant_type_id: " + retrieveTypeId(descr));

		return id;
	}

}
