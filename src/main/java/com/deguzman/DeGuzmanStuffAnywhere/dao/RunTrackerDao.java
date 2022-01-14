package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.RunTrackerInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.RunTracker;

public interface RunTrackerDao {

	public List<RunTrackerInfoDTO> findAllRunTrackerInformation();
	
	public List<RunTrackerInfoDTO> findRunTrackerInformationByUser(@PathVariable long user_id);
	
	public ResponseEntity<RunTrackerInfoDTO> findRunTrackerInformationById(@PathVariable long run_id);
	
	public long findCountOfRunTrackerInformation();
	
	public int addRunTrackerInformation(@RequestBody RunTracker runTracker);
	
	public int updateRunTrackerInformation(@PathVariable long run_id,
			@RequestBody RunTracker runTrackerDetails);
	
	public int deleteRunTrackerInformation(@PathVariable long run_id);
	
	public int deleteAllRunTrackerInformation();
	
}
