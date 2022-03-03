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

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao.GeneralTrxUploadDao;
import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.GeneralTrxFile;

@Service
public class GeneralTrxFileStorageService {

	@Autowired
	private GeneralTrxUploadDao generalTrxDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneralTrxFileStorageService.class);
	
	public GeneralTrxFile store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		File uploadFile = new File(filename);
		String path = uploadFile.getAbsolutePath();
		GeneralTrxFile photo = new GeneralTrxFile(filename, path,file.getContentType(), file.getBytes());
		
		LOGGER.info("Uploaded file: " + filename);
		
		return generalTrxDao.save(photo);
	}
	
	public GeneralTrxFile getFile(int fileId) {
		
		LOGGER.info("Retrieved file: " + fileId);
		
		return generalTrxDao.findById(fileId).get();
	}
	
	public Stream<GeneralTrxFile> getAllFiles() {
		
		LOGGER.info("Retrieving all Files...");
		
		return generalTrxDao.findAll().stream();
	}
}
