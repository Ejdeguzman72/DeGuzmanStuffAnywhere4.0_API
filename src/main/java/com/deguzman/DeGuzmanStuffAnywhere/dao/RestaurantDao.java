package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.RestaurantInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.InvalidRestaurantException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Restaurant;

public interface RestaurantDao {

	public List<RestaurantInfoDTO> findAllRestaurants();

	public List<RestaurantInfoDTO> findAllRestaurantsByType(@PathVariable int restaurant_type_id);

	public List<RestaurantInfoDTO> findRestaurantsByZipCode(@PathVariable String zip);

	public List<RestaurantInfoDTO> findRestaurantsByDescr(@PathVariable String descr);

	public ResponseEntity<RestaurantInfoDTO> findRestaurantById(@PathVariable int restaurant_id)
			throws InvalidRestaurantException;

	public ResponseEntity<RestaurantInfoDTO> findRestaurantByName(@PathVariable String name);

	public long getRestaurantCount();

	public int addRestaurantInformation(@RequestBody Restaurant restaurant) throws ResourceNotFoundException, DuplicateRestaurantException;

	public int updateRestaurantInformation(@PathVariable int restaurant_id, @RequestBody Restaurant restaurantDetails)
			throws ResourceNotFoundException;

	public int deleteRestaurantInformation(@PathVariable int restaurant_id);

	public int deleteAllRestaurantInformation();

}
