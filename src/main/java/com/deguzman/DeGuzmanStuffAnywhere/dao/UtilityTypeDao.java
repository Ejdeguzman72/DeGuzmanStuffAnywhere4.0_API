package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.model.UtilityType;

public interface UtilityTypeDao {

	public List<UtilityType> findAllUtilityTypes();

	public ResponseEntity<UtilityType> findUtilityInformationById(@PathVariable int utility_type_id);

	public ResponseEntity<UtilityType> findUtilityInformationByDescr(@PathVariable String descr);
}
