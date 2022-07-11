package com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_model.Item;
import com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_repository.ItemDaoImpl;

@Service
public class ItemService {
	
	@Autowired
	private ItemDaoImpl itemDaoImpl;
	
	public List<Item> findAllItemInfo() {
		return itemDaoImpl.findAllItemInfo();
	}
	
	public ResponseEntity<Item> findItemById(@PathVariable int itemId) {
		return itemDaoImpl.findItemById(itemId);
	}
	
	public ResponseEntity<Item> findItemByName(@PathVariable String name) {
		return itemDaoImpl.findItemByName(name);
	}
	
	public int addItemInformation(@RequestBody Item item) {
		return itemDaoImpl.addItemInformation(item);
	}
	
	public int updateItemInformation(@PathVariable int itemId, @RequestBody Item itemDetails) {
		return itemDaoImpl.updateItemInformation(itemId, itemDetails);
	}
	
	public int deleteAllItems() {
		return itemDaoImpl.deleteAllItems();
	}
	
	public int deleteItemInformation(@PathVariable int itemId) {
		return itemDaoImpl.deleteItemInformation(itemId);
	}
}
