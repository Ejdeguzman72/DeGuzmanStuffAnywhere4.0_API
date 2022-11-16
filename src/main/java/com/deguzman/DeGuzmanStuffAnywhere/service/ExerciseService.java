package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.ExerciseDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.dto.ExerciseInfoDTO;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.ExerciseJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Exercise;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
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

@Service
public class ExerciseService {

	@Autowired
	private ExerciseDaoImpl exerciseDaoImpl;
	
	@Autowired
	private ExerciseJpaDao exerciseDao;
	
	public ExerciseListResponse findAllExerciseInformation() {
		ExerciseListResponse response = new ExerciseListResponse();
		List<ExerciseInfoDTO> list = exerciseDaoImpl.findAllExerciseInformation();
		
		list = exerciseDaoImpl.findAllExerciseInformation();
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_EXERCISE_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_EXERCISE_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllExercisePagination(@RequestParam(required = false) String exerciseName,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<Exercise> shop = exerciseDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<Exercise> pageBooks = null;

			if (exerciseName == null) {
				pageBooks = exerciseDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("exercises", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ExerciseListResponse findExerciseInformationByUser(ExerciseSearchByUserRequest request) {
		ExerciseListResponse response = new ExerciseListResponse();
		List<ExerciseInfoDTO> list = exerciseDaoImpl.findExerciseInformationByUser(request.getUserId());
		
		response.setList(list);
		response.setSize(list.size());
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_EXERCISE_LIST_BY_USER_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_EXERCISE_LIST_BY_USER_MSG);
		
		return response;
	}
	
	public ExerciseListResponse findExerciseInformationByType(ExerciseSearchByTypeRequest request) {
		ExerciseListResponse response = new ExerciseListResponse();
		List<ExerciseInfoDTO> list = exerciseDaoImpl.findExerciseInformationByUser(request.getExerciseTypeId());
		
		response.setList(list);
		response.setSize(list.size());
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_EXERCISE_LIST_BY_TYPE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_EXERCISE_LIST_BY_TYPE_MSG);
		
		return response;
	}
	
	public ExerciseSearchResponse findExerciseDTOById(ExerciseSearchByIdRequest request) {
		ExerciseSearchResponse response = new ExerciseSearchResponse();
		ExerciseInfoDTO exercise = exerciseDaoImpl.findExerciseDTOById(request.getExerciseId());
		
		response.setExercise(exercise);
		response.setDescription(AppConstants.GET_EXERCISE_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_EXERCISE_BY_ID_MSG);
		
		return response;
	}
	
	public ExerciseAddResponse addExerciseInformation(ExerciseAddRequest request) {
		ExerciseAddResponse response = new ExerciseAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Exercise exercise = new com.deguzman.DeGuzmanStuffAnywhere.model.Exercise();
		exercise.setExerciseName(request.getExerciseName());
		exercise.setWeight(request.getWeight());
		exercise.setSets(request.getSets());
		exercise.setDate(request.getDate());
		exercise.setExercise_type_id(request.getExercise_type_id());
		exercise.setReps(request.getReps());
		exercise.setUser_id(request.getUser_id());
		
		int recordsAdded = exerciseDaoImpl.addExerciseInformation(request);
		
		response.setExercise(exercise);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_EXERCISE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_EXERCISE_INFORMATION_MSG);
		
		return response;
		
	}
	
	public ExerciseUpdateResponse updateExerciseInformation(ExerciseUpdateRequest request) {
		ExerciseUpdateResponse response = new ExerciseUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Exercise exercise = exerciseDaoImpl.findExerciseById(request.getExercise_id());
		int updatedRecords = exerciseDaoImpl.updateExerciseInformation(request.getExercise_id(), request);
		
		response.setExercise(exercise);
		response.setUpdatedCount(updatedRecords);
		response.setDescription(AppConstants.UPDATE_EXERCISE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_EXERCISE_INFORMATION_MSG);
		
		return response;
	}
	
	public ExerciseDeleteByIdResponse deleteExerciseInformationbyId(ExerciseDeleteByIdRequest request) {
		ExerciseDeleteByIdResponse response = new ExerciseDeleteByIdResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Exercise exercise = exerciseDaoImpl.findExerciseById(request.getExerciseId());
		int deletedRecords = exerciseDaoImpl.deleteExerciseInformationById(request.getExerciseId());
		
		response.setExercise(exercise);
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_EXERCISE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_EXERCISE_INFORMATION_MSG);
		
		return response;
	}
	
	public ExerciseDeleteAllResponse deleteAllExerciseInformation() {
		ExerciseDeleteAllResponse response = new ExerciseDeleteAllResponse();
		int deletedRecords =  exerciseDaoImpl.deleteAllExercisInformation();
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_ALL_EXERCISE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_EXERCISE_INFORMATION_MSG);
		
		return response;
	}

	public ModelExerciseSearchResponse findExerciseById(ExerciseSearchByIdRequest request) {
		ModelExerciseSearchResponse response = new ModelExerciseSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Exercise exercise = exerciseDaoImpl.findExerciseById(request.getExerciseId());
		response.setExercise(exercise);
		response.setDescription(AppConstants.GET_EXERCISE_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_EXERCISE_BY_ID_MSG);
		
		return response;
	}
}
