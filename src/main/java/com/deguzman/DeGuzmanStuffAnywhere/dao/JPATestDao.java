package com.deguzman.DeGuzmanStuffAnywhere.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.model.JPATestModel;

@Repository
public interface JPATestDao extends JpaRepository<JPATestModel,Integer> {

}
