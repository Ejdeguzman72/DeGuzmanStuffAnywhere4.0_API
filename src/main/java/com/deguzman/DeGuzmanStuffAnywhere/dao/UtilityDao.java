package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.UtilityInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Utility;

public interface UtilityDao {

	public List<UtilityInfoDTO> findAllUtilityInformation();

	public List<UtilityInfoDTO> findUtilityInformationByDueDate(@PathVariable String dueDate);

	public Utility findUtilityInformationById(@PathVariable long utility_id);

	public UtilityInfoDTO findUtilityInformationByName(@PathVariable String name);

	public UtilityInfoDTO findUtilityInformationByType(@PathVariable int utility_type_id);

	public long findUtilityCount();

	public int addUtilityInformation(@RequestBody Utility utility);

	public int updateUtilityInformation(@PathVariable long utility_id, @RequestBody Utility utilityDetails);

	public int deleteUtilityInformation(@PathVariable long utility_id);

	public int deleteAllUtilityInformation();

}
