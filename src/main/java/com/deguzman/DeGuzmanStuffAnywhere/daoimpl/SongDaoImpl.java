package com.deguzman.DeGuzmanStuffAnywhere.daoimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.deguzman.DeGuzmanStuffAnywhere.dao.SongDao;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateSongTitleException;
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
	@Cacheable(value = "songList")
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
	@Cacheable(value = "songById", key = "#song_id")
	public Song findSongById(int song_id) throws ResourceNotFoundException {
		Song song = jdbcTemplate.queryForObject(GET_SONG_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(Song.class), song_id);

		LOGGER.info("Retrieved Song Information: " + song.getTitle() + " " + song.getArtist());

		return song;
	}

	@Override
	public Song findSongByTitle(String title) {
		Song song = jdbcTemplate.queryForObject(GET_SONG_INFORMATION_BY_TITLE,
				BeanPropertyRowMapper.newInstance(Song.class), title);

		LOGGER.info("Retrieved Song Information: " + " " + song.getTitle() + " " + song.getArtist());

		return song;
	}

	@Override
	public int findSongCount() {
		int count = jdbcTemplate.queryForObject(GET_SONG_COUNT, Integer.class);

		LOGGER.info("Getting music count...");

		return count;
	}

	public boolean checkSongTitles(String title) {

		List<Song> bookList = findAllSongInformation();
		List<String> namesList;
		boolean result = false;

		namesList = bookList.stream().map(Song::getTitle).collect(Collectors.toList());

		if (namesList.contains(title)) {
			result = true;
		}

		return result;
	}
	
	@Override
	@CachePut(value = "songList")
	public int addSongInformation(Song song) throws DuplicateSongTitleException {

		String title = song.getTitle();
		String artist = song.getArtist();
		String genre = song.getGenre();

		if (checkSongTitles(title)) {
			throw new DuplicateSongTitleException("Song Already Exists");
		}
		
		LOGGER.info("Adding Song Information: " + title + " " + "by " + artist);

		return jdbcTemplate.update(ADD_SONG_INFORMATION, new Object[] { title, artist, genre });
	}

	@Override
	@CachePut(value = "songById", key = "#song_id")
	public int updateSongInformation(int song_id, Song songDetails) {

		int result = 0;
		
		Song song = jdbcTemplate.queryForObject(GET_SONG_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(Song.class), song_id);
		
		if (song != null) {
			song.setTitle(songDetails.getTitle());
			song.setArtist(songDetails.getArtist());
			song.setGenre(songDetails.getGenre());
			song.setSong_id(song_id);
			
			result = jdbcTemplate.update(UPDATE_SONG_INFORMATION, new Object[] {
					song.getTitle(),
					song.getArtist(),
					song.getGenre(),
					song.getSong_id()
			});
			
			LOGGER.info("Updating song info for song_id: " + song_id);
		}
		
		return result;
	}

	@Override
	@CachePut(value = "songById", key = "#song_id")
	public int deleteSongInformation(int song_id) {
		int count = jdbcTemplate.update(DELETE_SONG_INFORMATION_BY_ID, song_id);

		LOGGER.info("Deleting song with ID: " + song_id);

		return count;
	}

	@Override
	@Cacheable(value = "songList")
	public int deleteAllSongs() {
		int count = jdbcTemplate.update(DELETE_ALL_SONG_INFORMATION);

		LOGGER.info("Deleting all songs...");

		return count;
	}

}
