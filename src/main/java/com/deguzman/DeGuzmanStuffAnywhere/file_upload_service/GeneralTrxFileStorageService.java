package com.deguzman.DeGuzmanStuffAnywhere.file_upload_service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
		String path = "./uploads/general-transactions/" + uploadFile;
		
		Path targetPath = Paths.get(path);
		
		if (Files.exists(targetPath)) {
			File generalTrxUploadDir = new File("./uploads/general-transactions");
			
			generalTrxUploadDir.mkdirs();
		}
		
		InputStream inputStreamFile = file.getInputStream();
		
		Files.copy(inputStreamFile, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
		
		GeneralTrxFile photo = new GeneralTrxFile(filename, path,file.getContentType(), file.getBytes());
		
		LOGGER.info("Uploaded file: " + filename);
		
		return generalTrxDao.save(photo);
	}
	
	public GeneralTrxFile getFile(String fileId) {
		
		LOGGER.info("Retrieved file: " + fileId);
		
		return generalTrxDao.findById(fileId).get();
	}
	
	public Stream<GeneralTrxFile> getAllFiles() {
		
		LOGGER.info("Retrieving all Files...");
		
		return generalTrxDao.findAll().stream();
	}
}
