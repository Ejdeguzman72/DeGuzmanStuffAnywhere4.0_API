package com.deguzman.DeGuzmanStuffAnywhere.file_upload_service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao.PhotoUploadDao;
import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.Photos;

@Service
public class PhotosStorageService {

	@Autowired
	private PhotoUploadDao photoDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PhotosStorageService.class);
	
	public Photos store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		File uploadFile = new File(filename);
		String path = uploadFile.getAbsolutePath();
		Photos photo = new Photos(filename, path,file.getContentType(), file.getBytes());
		
		LOGGER.info("Uploaded file: " + filename);
		
		return photoDao.save(photo);
	}
	
	public Photos getPhoto(@PathVariable int photoId) {
		
		LOGGER.info("Retrieved file: " + photoId);
		
		return photoDao.findById(photoId).get();
	}
	
	public Stream<Photos> getAllPhotos() {
		
		LOGGER.info("Retrieving all Files...");
		
		return photoDao.findAll().stream();
	}
}
