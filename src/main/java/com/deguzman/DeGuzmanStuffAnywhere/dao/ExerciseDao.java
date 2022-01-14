package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.ExerciseInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Exercise;

public interface ExerciseDao {

	public List<ExerciseInfoDTO> findAllExerciseInformation();
	
	public List<ExerciseInfoDTO> findExerciseInformationByUser(@PathVariable long user_id);
	
	public List<ExerciseInfoDTO> findExerciseInformationByType(@PathVariable int exercise_type_id);
	
	public ResponseEntity<ExerciseInfoDTO> findExerciseById(@PathVariable int exercise_id);
	
	public int addExerciseInformation(@RequestBody Exercise exercise);
	
	public int updateExerciseInformation(@PathVariable int exercise_id,
			@RequestBody Exercise exerciseDetails);
	
	public int deleteExerciseInformationById(@PathVariable int exercise_id);
	
	public int deleteAllExercisInformation();
}
