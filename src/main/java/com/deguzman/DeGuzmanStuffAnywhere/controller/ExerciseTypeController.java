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
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExerciseTypeController {

	@Autowired
	private ExerciseTypeDaoImpl exerciseTypeDaoImpl;

	@GetMapping(value = UriConstants.URI_GET_EXERCISE_TYPE_LIST)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<ExerciseType> getAllExerciseTypeInformation() {
		return exerciseTypeDaoImpl.findAllExerciseTypeInformation();
	}

	@GetMapping(value = UriConstants.URI_GET_EXERCISE_TYPE_BY_ID)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<ExerciseType> getExerciseTypeById(@PathVariable int exercise_type_id) {
		return exerciseTypeDaoImpl.findExerciseTypeInformationById(exercise_type_id);
	}
}
