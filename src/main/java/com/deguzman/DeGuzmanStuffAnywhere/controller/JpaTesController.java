package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.dao.JPATestDao;
import com.deguzman.DeGuzmanStuffAnywhere.model.JPATestModel;

@RestController
@RequestMapping("/app/test-jpa")
@CrossOrigin
public class JpaTesController {

	@Autowired
	private JPATestDao jpaTestDao;
	
	@GetMapping("/all")
	public List<JPATestModel> getAll() {
		return jpaTestDao.findAll();
	}
}
