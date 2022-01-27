package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.AutoRepairShopJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.AutoRepairShop;

@Service
public class AutoRepairShopService {

	@Autowired
	private AutoRepairShopJpaDao autoShopDao;
	
	public ResponseEntity<Map<String, Object>> getAllAutoShopsPagination(@RequestParam(required = false) String autoShopname,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<AutoRepairShop> shop = autoShopDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<AutoRepairShop> pageBooks = null;

			if (autoShopname == null) {
				pageBooks = autoShopDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("shops", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
