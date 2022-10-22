package com.deguzman.DeGuzmanStuffAnywhere.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateBookNameException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Books;

public interface BooksDao {

	public List<Books> findAllBooksInformation();

	public List<Books> findAllBooksByAuthor(String author);

	public Books findBooksInformationById(@PathVariable int book_id) throws ResourceNotFoundException;

	public Books findBookInformationByName(String title);

	public long getBookCount();

	public int addBooksInformation(@RequestBody Books book) throws DuplicateBookNameException;

	public int updateBooksInformation(@PathVariable int book_id, @RequestBody Books book);

	public int deleteBookInformation(@PathVariable int book_id);

	public int deleteAllBookInformation();

}
