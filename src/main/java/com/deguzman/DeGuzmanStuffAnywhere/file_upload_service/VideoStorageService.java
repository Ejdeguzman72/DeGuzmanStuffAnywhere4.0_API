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

import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_dao.VideoUploadDao;
import com.deguzman.DeGuzmanStuffAnywhere.file_upload_jpa_models.Video;

@Service
public class VideoStorageService {

	@Autowired
	private VideoUploadDao videoDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(VideoStorageService.class);

	public Video store(MultipartFile file) throws IOException {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		File uploadFile = new File(filename);
		String path = "./uploads/videos/" + uploadFile;

		Path targetPath = Paths.get(path);

		if (Files.exists(targetPath)) {
			File generalTrxUploadDir = new File("./uploads/videos");

			generalTrxUploadDir.mkdirs();
		}

		InputStream inputStreamFile = file.getInputStream();

		Files.copy(inputStreamFile, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);

		Video photo = new Video(filename, path, file.getContentType(), file.getBytes());

		LOGGER.info("Uploaded file: " + filename);

		return videoDao.save(photo);
	}

	public Video getVideo(String videoId) {

		LOGGER.info("Retrieved file: " + videoId);

		return videoDao.findById(videoId).get();
	}

	public Stream<Video> getAllVideos() {

		LOGGER.info("Retrieving all Files...");

		return videoDao.findAll().stream();
	}
}
