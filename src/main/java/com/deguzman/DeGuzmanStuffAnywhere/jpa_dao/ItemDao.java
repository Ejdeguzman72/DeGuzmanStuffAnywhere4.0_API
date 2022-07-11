package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_model.Item;

public interface ItemDao {

	public List<Item> findAllItemInfo();
	
	public ResponseEntity<Item> findItemById(@PathVariable int itemId);
	
	public ResponseEntity<Item> findItemByName(@PathVariable String description);
	
	public int addItemInformation(@RequestBody Item item);
	
	public int updateItemInformation(@PathVariable int itemId, @RequestBody Item item);
	
	public int deleteAllItems();
	
	public int deleteItemInformation(@PathVariable int itemId);
	 
}
