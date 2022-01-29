package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.RestaurantTypeDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.RestaurantType;

@RestController
@RequestMapping("/app/restaurant-types")
@CrossOrigin
public class RestaurantTypeController {

	@Autowired
	private RestaurantTypeDaoImpl restaurantTypeDaoImpl;

	@GetMapping("/all")
	public List<RestaurantType> getAllRestaurantTypeInformation() {
		return restaurantTypeDaoImpl.findAllRestaurantTypeInformation();
	}

	@GetMapping("/type/{restaurant_type_id}")
	public ResponseEntity<RestaurantType> getRestaurantTypeById(@PathVariable int restaurant_type_id) {
		return restaurantTypeDaoImpl.findRestaurantInformationById(restaurant_type_id);
	}

	@GetMapping("/type/descr/{restaurantDescr}")
	public ResponseEntity<RestaurantType> getRestaurantTypeByDescr(@PathVariable String descr) {
		return restaurantTypeDaoImpl.findRestaurantTypeByDescr(descr);
	}

	@GetMapping("/type-count")
	public long getRestaurantTypeCount() {
		return restaurantTypeDaoImpl.getRestaurantTypeCount();
	}

}
