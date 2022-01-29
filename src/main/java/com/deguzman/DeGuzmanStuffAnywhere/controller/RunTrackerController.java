package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.RunTrackerDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.RunTrackerInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.RunTracker;

@RestController
@RequestMapping("/app/run-tracker-app")
@CrossOrigin
public class RunTrackerController {

	@Autowired
	private RunTrackerDaoImpl runTrackerDaoImpl;

	@GetMapping("/all")
	public List<RunTrackerInfoDTO> getAllRunTrackerInformation() {
		return runTrackerDaoImpl.findAllRunTrackerInformation();
	}

	@GetMapping("/run/user/{user_id}")
	public List<RunTrackerInfoDTO> getRunTrackerInformationByUser(@PathVariable long user_id) {
		return runTrackerDaoImpl.findRunTrackerInformationByUser(user_id);
	}

	@GetMapping("/run/{run_id}")
	public ResponseEntity<RunTrackerInfoDTO> getRunTrackerInformationById(@PathVariable long run_id) {
		return runTrackerDaoImpl.findRunTrackerInformationById(run_id);
	}

	@GetMapping("run-count")
	public long getRunCount() {
		return runTrackerDaoImpl.findCountOfRunTrackerInformation();
	}

	@PostMapping("/add-run-tracker-info")
	public int addRunTrackerInformation(@RequestBody RunTracker run) {
		return runTrackerDaoImpl.addRunTrackerInformation(run);
	}

	@DeleteMapping("/run/{run_id}")
	public int deleteRunTrackerInformationById(@PathVariable long run_id) {
		return runTrackerDaoImpl.deleteRunTrackerInformation(run_id);
	}

	@DeleteMapping("/delete-all-runs")
	public int deleteAllRunInformation() {
		return runTrackerDaoImpl.deleteAllRunTrackerInformation();
	}
}
