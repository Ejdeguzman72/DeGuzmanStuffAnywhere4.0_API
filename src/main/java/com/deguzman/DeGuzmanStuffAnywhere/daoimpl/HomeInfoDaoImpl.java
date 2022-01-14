package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.dao.HomeInfoDao;
import com.deguzman.DeGuzmanStuffAnywhere.model.HomeInfo;

@Repository
public class HomeInfoDaoImpl implements HomeInfoDao {

	String GET_HOME_INFO = "SELECT * FROM HOME";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<HomeInfo> getAllHomeInfo() {
		return jdbcTemplate.query(GET_HOME_INFO, BeanPropertyRowMapper.newInstance(HomeInfo.class));
	}

}
