package com.deguzman.DeGuzmanStuffAnywhere.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.RestaurantTypeDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

public class EntityDTOUtilConverter {

	@Autowired
	private RestaurantTypeDaoImpl restaurantTypeDaoImpl;

	public Restaurant convertRestaurantInfoDTO(RestaurantInfoDTO dtoObject) {
		Restaurant restaurant = new Restaurant();

		restaurant.setAddress(dtoObject.getAddress());
		restaurant.setCity(dtoObject.getCity());
		restaurant.setName(dtoObject.getName());
		restaurant.setState(dtoObject.getState());
		restaurant.setZip(dtoObject.getZip());

		int restaurantTypeId = restaurantTypeDaoImpl.retrieveTypeId(dtoObject.getDescr());

		restaurant.setRestaurant_type_id(restaurantTypeId);

		return restaurant;
	}
}
