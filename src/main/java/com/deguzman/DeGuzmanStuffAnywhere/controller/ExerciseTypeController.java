package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.ExerciseTypeDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.model.ExerciseType;

@RestController
@RequestMapping("/app/exercise-type")
@CrossOrigin
public class ExerciseTypeController {

	@Autowired
	private ExerciseTypeDaoImpl exerciseTypeDaoImpl;

	@GetMapping("/all")
	public List<ExerciseType> getAllExerciseTypeInformation() {
		return exerciseTypeDaoImpl.findAllExerciseTypeInformation();
	}

	@GetMapping("/type/{exercise_type_id}")
	public ResponseEntity<ExerciseType> getExerciseTypeById(@PathVariable int exercise_type_id) {
		return exerciseTypeDaoImpl.findExerciseTypeInformationById(exercise_type_id);
	}
}
