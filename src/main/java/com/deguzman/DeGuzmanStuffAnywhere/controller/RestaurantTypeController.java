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
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;

@RestController
@CrossOrigin
public class RestaurantTypeController {

	@Autowired
	private RestaurantTypeDaoImpl restaurantTypeDaoImpl;

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_TYPE_LIST)
	@CrossOrigin
	public List<RestaurantType> getAllRestaurantTypeInformation() {
		return restaurantTypeDaoImpl.findAllRestaurantTypeInformation();
	}

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_TYPE_BY_ID)
	@CrossOrigin
	public ResponseEntity<RestaurantType> getRestaurantTypeById(@PathVariable int restaurant_type_id) {
		return restaurantTypeDaoImpl.findRestaurantInformationById(restaurant_type_id);
	}

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_TYPE_BY_DESCR)
	@CrossOrigin
	public ResponseEntity<RestaurantType> getRestaurantTypeByDescr(@PathVariable String descr) {
		return restaurantTypeDaoImpl.findRestaurantTypeByDescr(descr);
	}

	@GetMapping(value = UriConstants.URI_GET_RESTAURANT_TYPE_COUNT)
	@CrossOrigin
	public long getRestaurantTypeCount() {
		return restaurantTypeDaoImpl.getRestaurantTypeCount();
	}

}
