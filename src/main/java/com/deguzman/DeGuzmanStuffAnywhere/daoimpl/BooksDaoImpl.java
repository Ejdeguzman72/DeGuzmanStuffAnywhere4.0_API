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
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.dao.BooksDao;
import com.deguzman.DeGuzmanStuffAnywhere.exception.BookNameException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Books;

@Repository
public class BooksDaoImpl implements BooksDao {

	String GET_ALL_BOOKS = "SELECT * FROM BOOKS ORDER BY Title";
	String GET_BOOK_INFORMATION_BY_ID = "SELECT * FROM BOOKS WHERE BOOK_ID = ?";
	String GET_BOOK_INFORMATION_BY_AUTHOR = "SELECT * FROM BOOKS WHERE AUTHOR = ?";
	String GET_BOOK_INFORMATION_NAME = "SELECT * FROM BOOKS WHERE Title = ?";
	String GET_BOOK_COUNT = "SELECT COUNT(*) FROM BOOKS";
	String ADD_BOOK_INFORMATION = "INSERT INTO BOOKS " + "(AUTHOR, DESCR, TITLE) " + "VALUES(?, ?, ?)";
	String UPDATE_BOOK_INFORMATION = "UPDATE books " + "SET author=?, descr=?, title=?" + "WHERE book_id=?";
	String DELETE_BOOK_INFORMATION_BY_ID = "DELETE FROM BOOKS WHERE BOOK_ID = ?";
	String DELETE_ALL_BOOK_INFORMATION = "DELETE FROM BOOKS";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final Logger LOGGER = LoggerFactory.getLogger(BooksDaoImpl.class);

	@Override
	public List<Books> findAllBooksInformation() {
		List<Books> booksList = jdbcTemplate.query(GET_ALL_BOOKS, BeanPropertyRowMapper.newInstance(Books.class));

		LOGGER.info("Retrieving all books...");

		return booksList;
	}

	@Override
	public List<Books> findAllBooksByAuthor(@PathVariable String author) {
		List<Books> booksListAuthor = jdbcTemplate.query(GET_BOOK_INFORMATION_BY_AUTHOR,
				(rs, rowNum) -> new Books(rs.getInt("BOOK_ID"), rs.getString("NAME"), rs.getString("DESCR"),
						rs.getString("AUTHOR")),
				author);

		LOGGER.info("Retriving all books by Author: " + author);

		return booksListAuthor;
	}

	@Override
	public ResponseEntity<Books> findBooksInformationById(@PathVariable int book_id) throws ResourceNotFoundException {
		Books book = jdbcTemplate.queryForObject(GET_BOOK_INFORMATION_BY_ID,
				BeanPropertyRowMapper.newInstance(Books.class), book_id);

		LOGGER.info("Retrieved Book Information By ID: " + book_id);

		return ResponseEntity.ok().body(book);
	}

	@Override
	public ResponseEntity<Books> findBookInformationByName(@PathVariable String name) {
		Books book = jdbcTemplate.queryForObject(GET_BOOK_INFORMATION_NAME,
				BeanPropertyRowMapper.newInstance(Books.class), name);

		LOGGER.info("Retrived Book Information: " + " " + book.getTitle() + " " + book.getAuthor());

		return ResponseEntity.ok().body(book);
	}

	@Override
	public long getBookCount() {
		long count = jdbcTemplate.queryForObject(GET_BOOK_COUNT, Integer.class);

		LOGGER.info("Getting count of all books...");

		return count;
	}

	@Override
	public int addBooksInformation(@RequestBody Books book) throws BookNameException {

		String author = book.getAuthor();
		String descr = book.getDescr();
		String name = book.getTitle();

		LOGGER.info("Adding book information: " + name + " " + author);

		return jdbcTemplate.update(ADD_BOOK_INFORMATION, new Object[] { author, descr, name });
	}

	@Override
	public int updateBooksInformation(int book_id, Books book) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookInformation(@PathVariable int book_id) {
		int count = jdbcTemplate.update(DELETE_BOOK_INFORMATION_BY_ID, book_id);

		LOGGER.info("Deleting Book With ID: " + book_id);

		return count;
	}

	@Override
	public int deleteAllBookInformation() {
		int count = jdbcTemplate.update(DELETE_ALL_BOOK_INFORMATION);

		LOGGER.info("Deleting all books...");

		return count;
	}

}
