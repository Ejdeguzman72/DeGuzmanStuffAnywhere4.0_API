package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

}
