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

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao.AutoTrxUploadDao;
import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.AutoTrxFile;

@Service
public class AutoTrxFileStorageService {

	@Autowired
	private AutoTrxUploadDao autoTrxDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AutoTrxFileStorageService.class);
	
	public AutoTrxFile store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		File uploadFile = new File(filename);
		String path = "./uploads/auto-transactions/" + uploadFile;
		
		Path targetPath = Paths.get(path);
		
		if (!Files.exists(targetPath)) {
			File autoTrxUploadDir = new File("./uploads/auto-transactions");
			
			autoTrxUploadDir.mkdirs();
		}
		
		InputStream inputStreamFile = file.getInputStream();
		
		Files.copy(inputStreamFile, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
		
		AutoTrxFile photo = new AutoTrxFile(filename, path,file.getContentType(), file.getBytes());
		
		LOGGER.info("Uploaded file: " + filename);
		
		return autoTrxDao.save(photo);
	}
	
	public AutoTrxFile getFile(String fileId) {
		
		LOGGER.info("Retrieved file: " + fileId);
		
		return autoTrxDao.findById(fileId).get();
	}
	
	public Stream<AutoTrxFile> getAllFiles() {
		
		LOGGER.info("Retrieving all Files...");
		
		return autoTrxDao.findAll().stream();
	}
}
