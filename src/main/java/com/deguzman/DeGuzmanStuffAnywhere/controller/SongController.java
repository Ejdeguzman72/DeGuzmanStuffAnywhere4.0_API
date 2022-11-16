package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateSongTitleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.service.SongService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.MusicAddRequest;
import com.deguzman.domain.MusicAddResponse;
import com.deguzman.domain.MusicDeleteAllResponse;
import com.deguzman.domain.MusicDeleteByIdRequest;
import com.deguzman.domain.MusicDeleteByIdResponse;
import com.deguzman.domain.MusicListResponse;
import com.deguzman.domain.MusicSearchByArtistRequest;
import com.deguzman.domain.MusicSearchByGenreRequest;
import com.deguzman.domain.MusicSearchByIdRequest;
import com.deguzman.domain.MusicSearchResponse;
import com.deguzman.domain.MusicUpdateRequest;
import com.deguzman.domain.MusicUpdateResponse;
import com.deguzman.domain.SuccessResponse;

@RestController
@CrossOrigin
public class SongController {

	@Autowired
	private SongService songService;

	@GetMapping(value = UriConstants.URI_GET_SONG_LIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicListResponse>> getAllSongInformation() {
		MusicListResponse response = songService.findAllSongInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_SONG_LIST_PAGINATION)
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllSongsPagination(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return songService.getAllSongsPagination(title, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_SONG_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicSearchResponse>> getSongInformationById(@RequestBody MusicSearchByIdRequest request) throws ResourceNotFoundException {
		MusicSearchResponse response = songService.findSongById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_SONG_BY_ARTIST)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicListResponse>> getSongInformationByArtist(@RequestBody MusicSearchByArtistRequest request) {
		MusicListResponse response = songService.findSongByArtist(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_SONG_BY_GENRE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicListResponse>> getSongInformationByGenre(@RequestBody MusicSearchByGenreRequest request) {
		MusicListResponse response = songService.findSongsByGenre(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_SONG_COUNT)
	@CrossOrigin
	public int getCountOfSongs() {
		return songService.findSongCount();
	}

	@PostMapping(value = UriConstants.URI_ADD_SONG_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicAddResponse>> addSongInformation(@RequestBody MusicAddRequest request) throws DuplicateSongTitleException {
		MusicAddResponse response = songService.addSongInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_SONG_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicUpdateResponse>> updateSongInformation(@RequestBody MusicUpdateRequest request) throws ResourceNotFoundException {
		MusicUpdateResponse response = songService.updateSongInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_SONG_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicDeleteByIdResponse>> deleteSongInformationById(@RequestBody MusicDeleteByIdRequest request) {
		MusicDeleteByIdResponse response = songService.deleteSongInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_SONG_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<MusicDeleteAllResponse>> deleteAllSongs() {
		MusicDeleteAllResponse response = songService.deleteAllSongs();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
