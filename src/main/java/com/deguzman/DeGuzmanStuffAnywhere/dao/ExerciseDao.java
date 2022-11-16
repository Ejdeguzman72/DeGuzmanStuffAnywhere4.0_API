package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dto.ExerciseInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.model.Exercise;

public interface ExerciseDao {

	public List<ExerciseInfoDTO> findAllExerciseInformation();

	public List<ExerciseInfoDTO> findExerciseInformationByUser(long user_id);

	public List<ExerciseInfoDTO> findExerciseInformationByType(int exercise_type_id);

	public ExerciseInfoDTO findExerciseDTOById(int exercise_id);
	
	public Exercise findExerciseById(int exercise_id);

	public int addExerciseInformation(@RequestBody Exercise exercise);

	public int updateExerciseInformation(@PathVariable int exercise_id, @RequestBody Exercise exerciseDetails);

	public int deleteExerciseInformationById(@PathVariable int exercise_id);

	public int deleteAllExercisInformation();
}
