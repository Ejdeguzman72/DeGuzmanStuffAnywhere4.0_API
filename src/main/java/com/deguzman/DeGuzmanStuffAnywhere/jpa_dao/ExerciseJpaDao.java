package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Exercise;

@Repository
public interface ExerciseJpaDao extends JpaRepository<Exercise, Integer> {

	Page<Exercise> findAll(Pageable pageable);
}
