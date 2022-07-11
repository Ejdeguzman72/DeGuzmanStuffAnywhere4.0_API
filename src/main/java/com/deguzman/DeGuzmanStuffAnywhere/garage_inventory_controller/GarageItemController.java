package com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_model.Item;
import com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_service.ItemService;

@RestController
@RequestMapping("/app/garage-inventory")
@CrossOrigin
public class GarageItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/all")
	public List<Item> getAllItemInfo() {
		return itemService.findAllItemInfo();
	}
	
	@GetMapping("/item/{itemId}")
	public ResponseEntity<Item> getItemById(@PathVariable int itemId) {
		return itemService.findItemById(itemId);
	}
	
	@GetMapping("/item/name/{name}")
	public ResponseEntity<Item> getItemByName(@PathVariable String name) {
		return itemService.findItemByName(name);
	}
	
	@PostMapping("/add-item-information")
	public int addItemInformatioN(@RequestBody Item item) {
		return itemService.addItemInformation(item);
	}
	
	@PutMapping("/item/{itemId}")
	public int updateItemInformation(@PathVariable int itemId, @RequestBody Item itemDetails) {
		return itemService.updateItemInformation(itemId, itemDetails);
	}
	
	@DeleteMapping("/delete-all")
	public int deleteAllItems() {
		return itemService.deleteAllItems();
	}
	
	@DeleteMapping("/item/{itemId}")
	public int deleteItemInformation(@PathVariable int itemId) {
		return itemService.deleteItemInformation(itemId);
	}
}
