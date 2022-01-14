package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.dao.UtilityTypeDao;
import com.deguzman.DeGuzmanStuffAnywhere.model.UtilityType;

@Repository
public class UtilityTypeDaoImpl implements UtilityTypeDao {

	String GET_ALL_UTILITY_TYPES = "SELECT * FROM UTILITY_TYPE";
	String GET_UTILITY_TYPE_BY_ID = "SELECT * FROM UTILITY_TYPE WHERE UTILITY_TYPE_ID = ?";
	String GET_UTILITY_TYPE_BY_DESCR = "SELECT * FROM UTILITY_TYPE WHERE UTILITY_TYPE_DESCR = ?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<UtilityType> findAllUtilityTypes() {
		return jdbcTemplate.query(GET_ALL_UTILITY_TYPES, BeanPropertyRowMapper.newInstance(UtilityType.class));
	}

	@Override
	public ResponseEntity<UtilityType> findUtilityInformationById(@PathVariable int utility_type_id) {
		UtilityType type = jdbcTemplate.queryForObject(GET_UTILITY_TYPE_BY_ID, BeanPropertyRowMapper.newInstance(UtilityType.class), utility_type_id);
		
		return ResponseEntity.ok().body(type);
	}

	@Override
	public ResponseEntity<UtilityType> findUtilityInformationByDescr(@PathVariable String utility_type_descr) {
		UtilityType type = jdbcTemplate.queryForObject(GET_UTILITY_TYPE_BY_DESCR, BeanPropertyRowMapper.newInstance(UtilityType.class), utility_type_descr);
		
		return ResponseEntity.ok().body(type);
	}

}
