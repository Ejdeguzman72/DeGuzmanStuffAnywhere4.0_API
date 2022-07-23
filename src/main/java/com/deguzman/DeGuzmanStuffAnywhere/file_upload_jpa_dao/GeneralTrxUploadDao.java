package com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.GeneralTrxFile;

@Repository
public interface GeneralTrxUploadDao extends JpaRepository<GeneralTrxFile, String>{

}
