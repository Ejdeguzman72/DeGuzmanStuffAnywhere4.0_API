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
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dao.AutoShopDao;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;

@Repository
public class AutoRepairShopDaoImpl implements AutoShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoRepairShopDaoImpl.class);
	
	
	String GET_ALL_AUTO_REPAIR_SHOPS = "SELECT * FROM AUTO_SHOP ORDER BY AUTO_SHOP_NAME";
	String GET_AUTO_SHOP_BY_ID = "SELECT * FROM AUTO_SHOP WHERE AUTO_SHOP_ID = ?";
	String GET_AUTO_SHOP_BY_NAME = "SELECT * FROM AUTO_SHOP WHERE AUTO_SHOP_NAME = ?";
	String GET_AUTO_REPAIR_SHOP_BY_ZIP = "SELECT * FROM AUTO_SHOP WHERE ZIP = ?";
	String GET_COUNT_OF_REPAIR_SHOPS = "SELECT COUNT(*) FROM AUTO_SHOP";
	String ADD_AUTO_SHOP_INFORMATION = "INSERT INTO auto_shop " + 
			"(address, auto_shop_name, city, state, zip) " + 
			"VALUES(?, ?, ?, ?, ?)";
	String UPDATE_AUTO_SHOP_INFORMATION = "UPDATE AUTO_SHOP SET AUTOSHOPNAME= ?, ADDRESS = ?. CITY = ?. STATE = ?, ZIP = ? WHERE AUTO_SHOP_ID = ?";
	String DELETE_AUTO_SHOP_INFORMATION_BY_ID = "DELETE FROM AUTO_SHOP WHERE AUTO_SHOP_ID = ?";
	String DELETE_ALL_AUTO_SHOPS = "DELETE FROM AUTO_SHOP";
	
	@Override
	public List<AutoRepairShop> findAllAutoRepairShopInfo() {
		List<AutoRepairShop> listAutoRepairShops = jdbcTemplate.query(GET_ALL_AUTO_REPAIR_SHOPS, BeanPropertyRowMapper.newInstance(AutoRepairShop.class));
		
		LOGGER.info("Retrieving all auto repair shops...");
		
		return listAutoRepairShops;
	}

	@Override
	public ResponseEntity<AutoRepairShop> findAutoRepairShopById(@PathVariable int auto_shop_id) {
		AutoRepairShop autoShop = jdbcTemplate.queryForObject(GET_AUTO_SHOP_BY_ID, BeanPropertyRowMapper.newInstance(AutoRepairShop.class), auto_shop_id);
		
		LOGGER.info("Retrieved Auto Repair Shop Information: " + autoShop.getAutoShopName() + "...");
		
		return ResponseEntity.ok().body(autoShop);
	}

	@Override
	public ResponseEntity<AutoRepairShop> findAutoRepairShopByName(@PathVariable String autoShopName) {
		AutoRepairShop autoShop = jdbcTemplate.queryForObject(GET_AUTO_SHOP_BY_NAME, BeanPropertyRowMapper.newInstance(AutoRepairShop.class), autoShopName);
		
		LOGGER.info("Retrieved Repair Shop Information: " + autoShop.getAutoShopName() + "...");
		
		return ResponseEntity.ok().body(autoShop);
	}

	@Override
	public List<AutoRepairShop> findAutoRepairShopByZip(@PathVariable String zip) {
		List<AutoRepairShop> autoShopList = jdbcTemplate.query(GET_AUTO_REPAIR_SHOP_BY_ZIP, (rs,rowNum) ->
			new AutoRepairShop(
					rs.getInt("AUTO_SHOP_ID"),
					rs.getString("AUTO_SHOP_NAME"),
					rs.getString("ADDRESS"),
					rs.getString("CITY"),
					rs.getString("STATE"),
					rs.getString("ZIP")
					), zip);
		
		LOGGER.info("Retrieving Auto Shops By ZipCocde " + zip + "...");
		
		return autoShopList;
	}

	@Override
	public long getCountOfAutoRepairShops() {
		long count = jdbcTemplate.queryForObject(GET_COUNT_OF_REPAIR_SHOPS, Integer.class);
		
		LOGGER.info("Getting count of Auto Repair Shops...");
		
		return count;
	}

	@Override
	public int addAutoRepairShopInfo(AutoRepairShop autoShop) {
		int count = jdbcTemplate.update(ADD_AUTO_SHOP_INFORMATION, new Object[] {
				autoShop.getAutoShopName(), autoShop.getAddress(), autoShop.getCity(), autoShop.getState(), autoShop.getZip()
		});
		
		LOGGER.info("Inserted Auto Repair Shop Information: " + autoShop.getAutoShopName() + "...");
		
		return count;
		
	}

	@Override
	public int updateAutoShopInfo(@PathVariable int auto_shop_id, @RequestBody AutoRepairShop autoRepairShop) {
		int count = jdbcTemplate.update(UPDATE_AUTO_SHOP_INFORMATION, auto_shop_id);
		
		LOGGER.info("Updating Auto Shop Information for ID: " + auto_shop_id);
		
		return count;
	}

	@Override
	public int deleteAutoRepairShopInfo(@PathVariable int auto_shop_id) {
		int count = jdbcTemplate.update(DELETE_AUTO_SHOP_INFORMATION_BY_ID, auto_shop_id);
		
		LOGGER.info("Deleting Auto Repair Shop with ID: " + " " + auto_shop_id + "...");
		
		return count;
	}

	@Override
	public int deleteAllAutoShop() {
		int count = jdbcTemplate.update(DELETE_ALL_AUTO_SHOPS);
		
		LOGGER.info("Deleting all Auto Repair Shops...");
		
		return count;
	}

}
