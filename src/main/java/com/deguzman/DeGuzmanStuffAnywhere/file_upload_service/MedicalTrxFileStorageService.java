package com.deguzman.DeGuzmanStuffAnywhere.file_upload_service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao.MedicalTrxUploadDao;
import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.MedicalTrxFile;

@Service
public class MedicalTrxFileStorageService {

	@Autowired
	private MedicalTrxUploadDao medicalTrxDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MedicalTrxFileStorageService.class);
	
	public MedicalTrxFile store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		File uploadFile = new File(filename);
		String path = uploadFile.getAbsolutePath();
		MedicalTrxFile photo = new MedicalTrxFile(filename, path,file.getContentType(), file.getBytes());
		
		LOGGER.info("Uploaded file: " + filename);
		
		return medicalTrxDao.save(photo);
	}
	
	public MedicalTrxFile getFile(int fileId) {
		
		LOGGER.info("Retrieved file: " + fileId);
		
		return medicalTrxDao.findById(fileId).get();
	}
	
	public Stream<MedicalTrxFile> getAllFiles() {
		
		LOGGER.info("Retrieving all Files...");
		
		return medicalTrxDao.findAll().stream();
	}
}
