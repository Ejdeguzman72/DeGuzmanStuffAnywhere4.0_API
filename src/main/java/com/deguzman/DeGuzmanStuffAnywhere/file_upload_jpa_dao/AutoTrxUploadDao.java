package com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.AutoTrxFile;

public interface AutoTrxUploadDao extends JpaRepository<AutoTrxFile, String> {
}
