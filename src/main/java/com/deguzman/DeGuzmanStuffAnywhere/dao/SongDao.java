package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateSongTitleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateTitleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Song;

public interface SongDao {

	public List<Song> findAllSongInformation();

	public List<Song> findSongByArtist(@PathVariable String artist);

	public List<Song> findSongsByGenre(@PathVariable String genre);

	public ResponseEntity<Song> findSongById(@PathVariable int song_id) throws ResourceNotFoundException;

	public ResponseEntity<Song> findSongByTitle(@PathVariable String title);

	public int findSongCount();

	public int addSongInformation(@RequestBody Song song) throws DuplicateSongTitleException;

	public int updateSongInformation(@PathVariable int song_id, @RequestBody Song songDetails);

	public int deleteSongInformation(int song_id);

	public int deleteAllSongs();
}
