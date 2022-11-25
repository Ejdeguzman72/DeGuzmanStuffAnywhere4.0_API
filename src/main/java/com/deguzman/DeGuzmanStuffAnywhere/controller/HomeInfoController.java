package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.HomeInfoDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.HomeInfo;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class HomeInfoController {

	@Autowired
	private HomeInfoDaoImpl homeInfoDaoImpl;

	@GetMapping(value = UriConstants.URI_GET_HOME_INFO)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<HomeInfo> getAllHomeInformation() {
		return homeInfoDaoImpl.getAllHomeInfo();
	}
}
