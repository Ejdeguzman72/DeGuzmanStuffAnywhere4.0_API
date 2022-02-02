package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.SongDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateTitleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Song;
import com.deguzman.DeGuzmanStuffAnywhere.service.SongPaginationService;

@RestController
@RequestMapping("/app/music")
@CrossOrigin
public class SongController {

	@Autowired
	private SongDaoImpl songDaoImpl;

	@Autowired
	private SongPaginationService songPageService;

	@GetMapping("/all")
	@CrossOrigin
	public List<Song> getAllSongInformation() {
		return songDaoImpl.findAllSongInformation();
	}

	@GetMapping("all-songs")
	@CrossOrigin
	public ResponseEntity<Map<String, Object>> getAllSongsPagination(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return songPageService.getAllSongsPagination(title, page, size);
	}

	@GetMapping("/song/{song_id}")
	@CrossOrigin
	public ResponseEntity<Song> getSongInformationById(@PathVariable int song_id) throws ResourceNotFoundException {
		return songDaoImpl.findSongById(song_id);
	}

	@GetMapping("/song/artist/{artist}")
	@CrossOrigin
	public List<Song> getSongInformationByArtist(@PathVariable String artist) {
		return songDaoImpl.findSongByArtist(artist);
	}

	@GetMapping("/song/genre/{genre}")
	@CrossOrigin
	public List<Song> getSongInformationByGenre(@PathVariable String genre) {
		return songDaoImpl.findSongsByGenre(genre);
	}

	@GetMapping("/count-of-songs")
	@CrossOrigin
	public int getCountOfSongs() {
		return songDaoImpl.findSongCount();
	}

	@PostMapping("/add-song-information")
	@CrossOrigin
	public int addSongInformation(@RequestBody Song song) throws DuplicateTitleException {
		return songDaoImpl.addSongInformation(song);
	}

	@DeleteMapping("/song/{song_id}")
	@CrossOrigin
	public int deleteSongInformationById(@PathVariable int song_id) {
		return songDaoImpl.deleteSongInformation(song_id);
	}

	@DeleteMapping("/delete-all-songs")
	@CrossOrigin
	public int deleteAllSongs() {
		return songDaoImpl.deleteAllSongs();
	}
}
