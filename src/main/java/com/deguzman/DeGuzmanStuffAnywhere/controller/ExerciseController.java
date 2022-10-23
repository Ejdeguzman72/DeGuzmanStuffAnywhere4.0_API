package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.deguzman.DeGuzmanStuffAnywhere.service.ExerciseService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.SuccessResponse;
import com.deguzman.domain_entity.AutoShopListResponse;
import com.deguzman.domain_fitness_app.ExerciseAddRequest;
import com.deguzman.domain_fitness_app.ExerciseAddResponse;
import com.deguzman.domain_fitness_app.ExerciseDeleteAllResponse;
import com.deguzman.domain_fitness_app.ExerciseDeleteByIdRequest;
import com.deguzman.domain_fitness_app.ExerciseDeleteByIdResponse;
import com.deguzman.domain_fitness_app.ExerciseListResponse;
import com.deguzman.domain_fitness_app.ExerciseSearchByIdRequest;
import com.deguzman.domain_fitness_app.ExerciseSearchByTypeRequest;
import com.deguzman.domain_fitness_app.ExerciseSearchByUserRequest;
import com.deguzman.domain_fitness_app.ExerciseSearchResponse;
import com.deguzman.domain_fitness_app.ExerciseUpdateRequest;
import com.deguzman.domain_fitness_app.ExerciseUpdateResponse;
import com.deguzman.domain_fitness_app.ModelExerciseSearchResponse;

@RestController
@CrossOrigin
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseInfoService;

	@GetMapping(value = UriConstants.URI_GET_EXERCISE_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseListResponse>> getAllExerciseInformation() {
		ExerciseListResponse response = exerciseInfoService.findAllExerciseInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_EXERCISE_LIST_PAGINATION)
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllExercisePagination(@RequestParam(required = false) String exerciseName,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return exerciseInfoService.getAllExercisePagination(exerciseName, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_EXERCISE_BY_USER)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseListResponse>> getExerciseInformationByUser(@RequestBody ExerciseSearchByUserRequest request) {
		ExerciseListResponse response = exerciseInfoService.findExerciseInformationByUser(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_EXERCISE_BY_TYPE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseListResponse>> getExerciseInformationbyType(@RequestBody ExerciseSearchByTypeRequest request) {
		ExerciseListResponse response = exerciseInfoService.findExerciseInformationByType(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_EXERCISE_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ModelExerciseSearchResponse>> getExerciseById(@RequestBody ExerciseSearchByIdRequest request) {
		ModelExerciseSearchResponse response = exerciseInfoService.findExerciseById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@GetMapping(value = UriConstants.URI_GET_EXERCISE_DTO_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseSearchResponse>> getExerciseDTOById(@RequestBody ExerciseSearchByIdRequest request) {
		ExerciseSearchResponse response = exerciseInfoService.findExerciseDTOById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PostMapping(value = UriConstants.URI_ADD_EXERCISE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseAddResponse>> addExerciseInformation(@RequestBody ExerciseAddRequest request) {
		ExerciseAddResponse response = exerciseInfoService.addExerciseInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_EXERCISE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseUpdateResponse>> updateExerciseInformation(@RequestBody ExerciseUpdateRequest request) {
		ExerciseUpdateResponse response = exerciseInfoService.updateExerciseInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_EXERCISE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseDeleteByIdResponse>> deleteExerciseById(@RequestBody ExerciseDeleteByIdRequest request) {
		ExerciseDeleteByIdResponse response = exerciseInfoService.deleteExerciseInformationbyId(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_EXERCISE_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<ExerciseDeleteAllResponse>> deleteAllExercises() {
		ExerciseDeleteAllResponse response = exerciseInfoService.deleteAllExerciseInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
