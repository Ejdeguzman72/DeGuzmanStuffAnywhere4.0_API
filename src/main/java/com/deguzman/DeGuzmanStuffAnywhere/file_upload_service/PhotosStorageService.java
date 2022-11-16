package com.deguzman.DeGuzmanStuffAnywhere.file_upload_service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao.PhotoUploadDao;
import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.Photos;

@Service
public class PhotosStorageService {

	@Autowired
	private PhotoUploadDao photoDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PhotosStorageService.class);
	
	public Photos store(MultipartFile file) throws IOException {
		LocalDate submissionDate = LocalDate.now();
		String filename = StringUtils.cleanPath(submissionDate + " " + file.getOriginalFilename());
		File uploadFile = new File(filename);
		String path = "./uploads" + "/photos/" + uploadFile;
		
		Path targetPath = Paths.get(path);
		
		if (!Files.exists(targetPath)) {
			File photoUploadsDirectory = new File("./uploads/photos");
			
			photoUploadsDirectory.mkdirs();
		}
		
		InputStream inputStreamFile = file.getInputStream();
		
		Files.copy(inputStreamFile, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
		
		Photos photo = new Photos(filename, path,file.getContentType(), file.getBytes());		
		
		
		LOGGER.info("Uploaded file: " + filename);
		
		return photoDao.save(photo);
	}
	
	public Photos getPhoto(String photoId) {
		
		LOGGER.info("Retrieved file: " + photoId);
		
		return photoDao.getById(photoId);
	}
	
	public Stream<Photos> getAllPhotos() {
		
		LOGGER.info("Retrieving all Files...");
		
		return photoDao.findAll().stream();
	}
}
