package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.AutoRepairShopDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.AutoRepairShop;
import com.deguzman.DeGuzmanStuffAnywhere.service.AutoRepairShopPaginationService;

@RestController
@RequestMapping("/app/auto-repair-shops")
@CrossOrigin
public class AutoShopController {

	@Autowired
	private AutoRepairShopDaoImpl autoShopDaoImpl;
	
	@Autowired
	private AutoRepairShopPaginationService autoShopService;
	
	@GetMapping("/all")
	public List<AutoRepairShop> getAllAutoRepairShopInformation() {
		return autoShopDaoImpl.findAllAutoRepairShopInfo();
	}
	
	@GetMapping("/all-shops")
	public ResponseEntity<Map<String, Object>> getAllAutoShopsPagination(@RequestParam(required = false) String autoShopName,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return autoShopService.getAllAutoShopsPagination(autoShopName, page, size);
	}
	
	@GetMapping("/repair-shop/{auto_shop_id}")
	public ResponseEntity<AutoRepairShop> getAutoRepairShopInfoById(@PathVariable int auto_shop_id) {
		return autoShopDaoImpl.findAutoRepairShopById(auto_shop_id);
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
	
	@PutMapping("/repair-shop/{auto_shop_id}")
	public int updateAutoRepairShopInformation(@PathVariable int auto_shop_id, @RequestBody AutoRepairShop autoRepairShop) {
		return autoShopDaoImpl.updateAutoShopInfo(auto_shop_id, autoRepairShop);
	}
	
	@DeleteMapping("/repair-shop/{auto_shop_id}")
	@CrossOrigin
	public int deleteAutoShopInformationById(@PathVariable int auto_shop_id) {
		return autoShopDaoImpl.deleteAutoRepairShopInfo(auto_shop_id);
	}
	
	@DeleteMapping("/delete-all")
	public int deleteAllAutoRepairShopInformation() {
		return autoShopDaoImpl.deleteAllAutoShop();
	}
}
