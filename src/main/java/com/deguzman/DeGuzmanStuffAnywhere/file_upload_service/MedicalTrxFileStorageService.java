package com.deguzman.DeGuzmanStuffAnywhere.file_upload_service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
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
		LocalDateTime dateTime = LocalDateTime.now();
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		File uploadFile = new File(filename);
		String path = "./uploads/medical-transactions/" + uploadFile;
		
		Path targetPath = Paths.get(path);
		
		if (Files.exists(targetPath)) {
			File medicalTrxUploadDir = new File("/uploads/medical-transactions");
			
			medicalTrxUploadDir.mkdirs();
		}
		
		InputStream inputStreamFile = file.getInputStream();
		
		Files.copy(inputStreamFile, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
		
		MedicalTrxFile photo = new MedicalTrxFile(filename, path,file.getContentType(), file.getBytes());
		
		LOGGER.info("Uploaded file: " + filename);
		
		return medicalTrxDao.save(photo);
	}
	
	public MedicalTrxFile getFile(String fileId) {
		
		LOGGER.info("Retrieved file: " + fileId);
		
		return medicalTrxDao.findById(fileId).get();
	}
	
	public Stream<MedicalTrxFile> getAllFiles() {
		
		LOGGER.info("Retrieving all Files...");
		
		return medicalTrxDao.findAll().stream();
	}
}
