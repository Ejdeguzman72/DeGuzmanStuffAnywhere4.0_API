package com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.garage_inventory_model.Item;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.ItemDao;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class);
	
	String GET_ALL_ITEMS = "SELECT * FROM ITEMS";
	String GET_ITEM_BY_ID = "SELECT * FROM ITEMS WHERE ITEMID = ?";
	String GET_ITEM_BY_NAME = "SELECT * FROM ITEMS WHERE DESCRIPTION = ?";
	String ADD_ITEM_INFORMATION = "INSERT INTO ITEMS(itemId, name, quantity, condition) VALUES (?,?,?,?)";
	String UPDATE_ITEM_INFORMATION = "UPDATE ITEMS SET name = ?, quantity = ?, condition = ? WHERE itemId = ?";
	String DELETE_ALL_ITEMS = "DELETE FROM ITEMS";
	String DELETE_ITEM_INFORMATION = "DELETE FROM ITEMS WHERE ITEMID = ?";
	
	@Override
	public List<Item> findAllItemInfo() {
		List<Item> itemList = jdbcTemplate.query(GET_ALL_ITEMS, BeanPropertyRowMapper.newInstance(Item.class));
		
		LOGGER.info("Retrieving all Item information...");
		
		return itemList;
	}

	@Override
	public ResponseEntity<Item> findItemById(int itemId) {
		Item item = jdbcTemplate.queryForObject(GET_ITEM_BY_ID, BeanPropertyRowMapper.newInstance(Item.class), itemId);
		
		return ResponseEntity.ok().body(item);
	}

	@Override
	public ResponseEntity<Item> findItemByName(String name) {
		Item item = jdbcTemplate.queryForObject(GET_ITEM_BY_NAME, BeanPropertyRowMapper.newInstance(Item.class), name);
		
		LOGGER.info("Finding item by name: " + name);
		
		return ResponseEntity.ok().body(item);
	}

	@Override
	public int addItemInformation(Item item) {
		String name = item.getName();
		int quantity = item.getQuantity();
		String condition = item.getCondition();
		
		LOGGER.info("Adding item information: " + item.getName());
		
		int count = jdbcTemplate.update(ADD_ITEM_INFORMATION, new Object[] { name, quantity, condition });
		
		return count;
	}

	@Override
	public int updateItemInformation(int itemId, Item itemDetails) {

		int result = 0;
		
		Item item = jdbcTemplate.queryForObject(GET_ITEM_BY_ID, BeanPropertyRowMapper.newInstance(Item.class), itemId);
		
		if (item != null) {
			item.setCondition(itemDetails.getCondition());
			item.setName(itemDetails.getName());
			item.setQuantity(itemDetails.getQuantity());
			
			result = jdbcTemplate.update(UPDATE_ITEM_INFORMATION, new Object[] {
					item.getCondition(),
					item.getName(),
					item.getQuantity()
			});
			
			LOGGER.info("Updating item information with ID: " + itemId);
		}
		
		
		return result;
	}

	@Override
	public int deleteAllItems() {
		int count = jdbcTemplate.update(DELETE_ALL_ITEMS);
		
		LOGGER.info("Deleting all item information...");
		
		return count;
	}

	@Override
	public int deleteItemInformation(int itemId) {
		int count = jdbcTemplate.update(DELETE_ITEM_INFORMATION, itemId);
		
		LOGGER.info("Deleting item with ID: " + itemId);
		
		return count;
	}

}
