package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.ExerciseDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.ExerciseInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Exercise;
import com.deguzman.DeGuzmanStuffAnywhere.service.ExercisePaginationService;

@RestController
@RequestMapping("/app/gym-tracker")
@CrossOrigin
public class ExerciseController {

	@Autowired
	private ExerciseDaoImpl exerciseDaoImpl;
	
	@Autowired
	private ExercisePaginationService exercisePageService;

	@GetMapping("/all")
	@CrossOrigin
	public List<ExerciseInfoDTO> getAllExerciseInformation() {
		return exerciseDaoImpl.findAllExerciseInformation();
	}
	
	@GetMapping("/all-exercises")
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllExercisePagination(@RequestParam(required = false) String exerciseName,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return exercisePageService.getAllExercisePagination(exerciseName, page, size);
	}

	@GetMapping("/all/name/{user_id}")
	@CrossOrigin
	public List<ExerciseInfoDTO> getExerciseInformationByUser(@PathVariable long user_id) {
		return exerciseDaoImpl.findExerciseInformationByUser(user_id);
	}

	@GetMapping("/all/exercise-type/{exercise_type_id}")
	@CrossOrigin
	public List<ExerciseInfoDTO> getExerciseInformationbyType(@PathVariable int exercise_type_id) {
		return exerciseDaoImpl.findExerciseInformationByType(exercise_type_id);
	}

	@GetMapping("/exercise/{exercise_id}")
	@CrossOrigin
	public ResponseEntity<ExerciseInfoDTO> getExerciseById(@PathVariable int exercise_id) {
		return exerciseDaoImpl.findExerciseById(exercise_id);
	}

	@PostMapping("/add-exercise-information")
	@CrossOrigin
	public int addExerciseInformation(@RequestBody Exercise exercise) {
		return exerciseDaoImpl.addExerciseInformation(exercise);
	}
	
	@PutMapping("/exercise/{exercise_id}")
	@CrossOrigin
	public int updateExerciseInformation(@PathVariable int exercise_id, @RequestBody Exercise exerciseDetails) {
		return exerciseDaoImpl.updateExerciseInformation(exercise_id, exerciseDetails);
	}

	@DeleteMapping("/exercise/{exercise_id}")
	@CrossOrigin
	public int deleteExerciseById(@PathVariable int exercise_id) {
		return exerciseDaoImpl.deleteExerciseInformationById(exercise_id);
	}

	@DeleteMapping("/delete-all-exercises")
	@CrossOrigin
	public int deleteAllExercises() {
		return exerciseDaoImpl.deleteAllExercisInformation();
	}
}
