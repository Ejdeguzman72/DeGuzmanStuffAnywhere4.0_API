package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.AutoRepairShopDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;

@RestController
@RequestMapping("/app/auto-repair-shops")
@CrossOrigin
public class AutoShopController {

	@Autowired
	private AutoRepairShopDaoImpl autoShopDaoImpl;
	
	@GetMapping("/all")
	public List<AutoRepairShop> getAllAutoRepairShopInformation() {
		return autoShopDaoImpl.findAllAutoRepairShopInfo();
	}
	
	@GetMapping("/repair-shop/{autoShopId}")
	public ResponseEntity<AutoRepairShop> getAutoRepairShopInfoById(@PathVariable int autoShopId) {
		return autoShopDaoImpl.findAutoRepairShopById(autoShopId);
	}
	
	@GetMapping("/repair-shop/name/{autoShopName}")
	public ResponseEntity<AutoRepairShop> getAutoRepairShopByName(@PathVariable String autoShopName) {
		return autoShopDaoImpl.findAutoRepairShopByName(autoShopName);
	}
	
	@GetMapping("/repair-shop/zip/{zip}")
	public List<AutoRepairShop> getAutoRepairShopByZip(@PathVariable String zip) {
		return autoShopDaoImpl.findAutoRepairShopByZip(zip);
	}
	
	@GetMapping("/repair-shop/count")
	public long getCountOfAllRepairShops() {
		return autoShopDaoImpl.getCountOfAutoRepairShops();
	}
	
	@PostMapping("/add-auto-shop")
	public int addAutoRepairShopInformation(@RequestBody AutoRepairShop autoShop) {
		return autoShopDaoImpl.addAutoRepairShopInfo(autoShop);
	}
	
	@DeleteMapping("/repair-shop/{autoRepairShopId}")
	public int deleteAutoShopInformationById(@PathVariable int autoShopId) {
		return autoShopDaoImpl.deleteAutoRepairShopInfo(autoShopId);
	}
	
	@DeleteMapping("/delete-all")
	public int deleteAllAutoRepairShopInformation() {
		return autoShopDaoImpl.deleteAllAutoShop();
	}
}
