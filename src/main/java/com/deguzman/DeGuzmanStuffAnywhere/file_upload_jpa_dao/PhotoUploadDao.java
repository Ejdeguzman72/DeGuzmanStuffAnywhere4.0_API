package com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.Photos;

@Repository
public interface PhotoUploadDao extends JpaRepository<Photos,Integer> {

}
