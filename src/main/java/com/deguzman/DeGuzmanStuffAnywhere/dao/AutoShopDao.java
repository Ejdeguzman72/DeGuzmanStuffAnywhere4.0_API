package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;

public interface AutoShopDao {

	public List<AutoRepairShop> findAllAutoRepairShopInfo();
	
	public ResponseEntity<AutoRepairShop> findAutoRepairShopById(@PathVariable int autoShopId);
	
	public ResponseEntity<AutoRepairShop> findAutoRepairShopByName(@PathVariable String autoShopName);
	
	public List<AutoRepairShop> findAutoRepairShopByZip(@PathVariable String zip);
	
	public long getCountOfAutoRepairShops();
	
	public int addAutoRepairShopInfo(@RequestBody AutoRepairShop autoShop);
	
	public int updateAutoShopInfo(@PathVariable int autoShopId, @RequestBody AutoRepairShop autoRepairShop);
	
	public int deleteAutoRepairShopInfo(@PathVariable int autoShopId);
	
	public int deleteAllAutoShop();
}
