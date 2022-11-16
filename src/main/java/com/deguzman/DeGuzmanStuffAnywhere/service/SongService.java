package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.SongDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateSongTitleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.SongJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Song;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
import com.deguzman.domain.MusicAddRequest;
import com.deguzman.domain.MusicAddResponse;
import com.deguzman.domain.MusicDeleteAllResponse;
import com.deguzman.domain.MusicDeleteByIdRequest;
import com.deguzman.domain.MusicDeleteByIdResponse;
import com.deguzman.domain.MusicListResponse;
import com.deguzman.domain.MusicSearchByArtistRequest;
import com.deguzman.domain.MusicSearchByGenreRequest;
import com.deguzman.domain.MusicSearchByIdRequest;
import com.deguzman.domain.MusicSearchByTitleRequest;
import com.deguzman.domain.MusicSearchResponse;
import com.deguzman.domain.MusicUpdateRequest;
import com.deguzman.domain.MusicUpdateResponse;

@Service
public class SongService {

	@Autowired
	private SongDaoImpl songDaoImpl;
	
	@Autowired
	private SongJpaDao songJpaDao;
	
	public MusicListResponse findAllSongInformation() {
		MusicListResponse response = new MusicListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Song> list = songDaoImpl.findAllSongInformation();
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MUSIC_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MUSIC_LIST_MSG);
		
		return response;
	}

	public ResponseEntity<Map<String, Object>> getAllSongsPagination(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<Song> shop = songJpaDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<Song> pageBooks = null;

			if (title == null) {
				pageBooks = songJpaDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("songs", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public MusicListResponse findSongByArtist(MusicSearchByArtistRequest request) {
		MusicListResponse response = new MusicListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Song> list = songDaoImpl.findSongByArtist(request.getArtist());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MUSIC_LIST_BY_ARTIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MUSIC_LIST_BY_ARTIST_MSG);
		
		return response;
	}
	
	public MusicListResponse findSongsByGenre(MusicSearchByGenreRequest request) {
		MusicListResponse response = new MusicListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Song> list = songDaoImpl.findSongsByGenre(request.getGenre());
		
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_MUSIC_BY_GENRE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MUSIC_BY_GENRE_MSG);
		
		return response;
	}
	
	public MusicSearchResponse findSongById(MusicSearchByIdRequest request) throws ResourceNotFoundException {
		MusicSearchResponse response = new MusicSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Song song = songDaoImpl.findSongById(request.getMusicId());
		
		response.setSong(song);
		response.setDescription(AppConstants.GET_MEDICAL_OFFICE_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MEDICAL_OFFICE_BY_ID_MSG);
		
		return response;
	}
	
	public MusicSearchResponse findSongByTitle(MusicSearchByTitleRequest request) {
		MusicSearchResponse response = new MusicSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Song song = songDaoImpl.findSongByTitle(request.getTitle());
		
		response.setSong(song);
		response.setDescription(AppConstants.GET_MUSIC_LIST_BY_TITLE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_MUSIC_LIST_BY_TITLE_MSG);
		
		return response;
	}
	
	public int findSongCount() {
		return songDaoImpl.findSongCount();
	}
	
	public MusicAddResponse addSongInformation(MusicAddRequest request) throws DuplicateSongTitleException {
		MusicAddResponse response = new MusicAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Song song = new com.deguzman.DeGuzmanStuffAnywhere.model.Song();
		
		song.setTitle(request.getTitle());
		song.setArtist(request.getArtist());
		song.setGenre(request.getGenre());
		
		int recordsAdded = songDaoImpl.addSongInformation(song);
		
		response.setSong(song);
		response.setRecordsAdded(recordsAdded);
		response.setDescription(AppConstants.ADD_MUSIC_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_MUSIC_INFORMATION_MSG);
		
		return response;
		
	}
	
	public MusicUpdateResponse updateSongInformation(MusicUpdateRequest request) throws ResourceNotFoundException {
		MusicUpdateResponse response = new MusicUpdateResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Song song = songDaoImpl.findSongById(request.getSong_id());
		int updatedRecords = songDaoImpl.updateSongInformation(request.getSong_id(), request);
		
		response.setUpdatedCount(updatedRecords);
		response.setDescription(AppConstants.UPDATE_MUSIC_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_MUSIC_INFORMATION_MSG);
		
		return response;
	}
	
	public MusicDeleteByIdResponse deleteSongInformation(MusicDeleteByIdRequest request) {
		MusicDeleteByIdResponse response = new MusicDeleteByIdResponse();
		int recordsDeleted = songDaoImpl.deleteSongInformation(request.getSongId());
		
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_MEDICAL_OFFICE_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_MEDICAL_OFFICE_INFORMATION_MSG);
		
		return response;
	}
	
	public MusicDeleteAllResponse deleteAllSongs() {
		MusicDeleteAllResponse response = new MusicDeleteAllResponse();
		int recordsDeleted = songDaoImpl.deleteAllSongs();
		
		response.setDeleted(recordsDeleted);
		response.setDescription(AppConstants.DELETE_ALL_MUSIC_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_MUSIC_INFORMATION_MSG);
		
		return response;
	}
}
