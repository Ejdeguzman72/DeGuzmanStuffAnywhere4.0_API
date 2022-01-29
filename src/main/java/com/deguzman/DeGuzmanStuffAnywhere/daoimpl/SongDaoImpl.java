package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.dao.SongDao;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateTitleException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Song;

@Repository
public class SongDaoImpl implements SongDao {

	String GET_ALL_SONGS = "SELECT * FROM SONG ORDER BY TITLE, ARTIST";
	String GET_SONG_INFORMATION_BY_ID = "SELECT * FROM SONG WHERE SONG_ID = ?";
	String GET_SONG_INFORMATION_BY_ARTIST = "SELECT * FROM SONG WHERE ARTIST = ?";
	String GET_SONG_INFORMATION_BY_TITLE = "SELECT * FROM SONG WHERE TITLE = ?";
	String GET_SONG_INFORMATION_BY_GENRE = "SELECT * FROM SONG WHERE GENRE = ?";
	String GET_SONG_COUNT = "SELECT COUNT(*) FROM SONG";
	String ADD_SONG_INFORMATION = "INSERT INTO song " + "(artist, genre, title) " + "VALUES(?, ?, ?)";
	String UPDATE_SONG_INFORMATION = "UPDATE SONG SET TITLE = ?, ARTIST = ?, GENRE = ? WHERE SONG_ID = ?";
	String DELETE_SONG_INFORMATION_BY_ID = "DELETE FROM SONG WHERE SONG_ID = ?";
	String DELETE_ALL_SONG_INFORMATION = "DELETE FROM SONG";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Logger LOGGER = LoggerFactory.getLogger(SongDaoImpl.class);

	@Override
	public List<Song> findAllSongInformation() {
		List<Song> list = jdbcTemplate.query(GET_ALL_SONGS, BeanPropertyRowMapper.newInstance(Song.class));

		LOGGER.info("Retrieving all songs...");

		return list;
	}

	@Override
	public List<Song> findSongByArtist(@PathVariable String artist) {
		List<Song> songListArtist = jdbcTemplate.query(GET_SONG_INFORMATION_BY_ARTIST,
				(rs, rowNum) -> new Song(rs.getInt("song_id"), rs.getString("artist"), rs.getString("genre"),
						rs.getString("title")),
				artist);

		LOGGER.info("Retrieving music by artist: " + artist);

		return songListArtist;
	}

	@Override
	public List<Song> findSongsByGenre(@PathVariable String genre) {
		List<Song> songListGenre = jdbcTemplate.query(GET_SONG_INFORMATION_BY_GENRE,
				(rs, rowNum) -> new Song(rs.getInt("song_id"), rs.getString("title"), rs.getString("artist"),
						rs.getString("genre")),
				genre);

		LOGGER.info("Retrieving music by genre: " + genre);

		return songListGenre;
	}

	@Override
	public ResponseEntity<Song> findSongById(int song_id) throws ResourceNotFoundException {
		Song song = jdbcTemplate.queryForObject(GET_SONG_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(Song.class), song_id);

		LOGGER.info("Retrieved Song Information: " + song.getTitle() + " " + song.getArtist());

		return ResponseEntity.ok().body(song);
	}

	@Override
	public ResponseEntity<Song> findSongByTitle(String title) {
		Song song = jdbcTemplate.queryForObject(GET_SONG_INFORMATION_BY_TITLE,
				BeanPropertyRowMapper.newInstance(Song.class), title);

		LOGGER.info("Retrieved Song Information: " + " " + song.getTitle() + " " + song.getArtist());

		return ResponseEntity.ok().body(song);
	}

	@Override
	public int findSongCount() {
		int count = jdbcTemplate.queryForObject(GET_SONG_COUNT, Integer.class);

		LOGGER.info("Getting music count...");

		return count;
	}

	@Override
	public int addSongInformation(Song song) throws DuplicateTitleException {

		String title = song.getTitle();
		String artist = song.getArtist();
		String genre = song.getGenre();

		LOGGER.info("Adding Song Information: " + title + " " + "by " + artist);

		return jdbcTemplate.update(ADD_SONG_INFORMATION, new Object[] { title, artist, genre });
	}

	@Override
	public int updateSongInformation(int song_id, Song songDetails) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSongInformation(int song_id) {
		int count = jdbcTemplate.update(DELETE_SONG_INFORMATION_BY_ID, song_id);

		LOGGER.info("Deleting song with ID: " + song_id);

		return count;
	}

	@Override
	public int deleteAllSongs() {
		int count = jdbcTemplate.update(DELETE_ALL_SONG_INFORMATION);

		LOGGER.info("Deleting all songs...");

		return count;
	}

}
