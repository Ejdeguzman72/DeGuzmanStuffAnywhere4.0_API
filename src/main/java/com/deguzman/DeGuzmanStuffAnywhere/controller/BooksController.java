package com.deguzman.DeGuzmanStuffAnywhere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.BooksDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.BookNameException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Books;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/books")
@CrossOrigin
public class BooksController {

	@Autowired
	private BooksDaoImpl booksDaoImpl;
	
	@GetMapping("/all")
	public List<Books> getAllBooksInformation() {
		return booksDaoImpl.findAllBooksInformation();
	}
	
	@GetMapping("/book/artist/{author}")
	public List<Books> getBooksInformationByAuthor(@PathVariable String author) {
		return booksDaoImpl.findAllBooksByAuthor(author);
	}
	
	@GetMapping("/book/{book_id}")
	public ResponseEntity<Books> getBookInformationById(@PathVariable int book_id) throws ResourceNotFoundException {
		return booksDaoImpl.findBooksInformationById(book_id);
	}
	
	@GetMapping("/book/name/{name}")
	public ResponseEntity<Books> getBookInformationByName(@PathVariable String name) {
		return booksDaoImpl.findBookInformationByName(name);
	}
	
	@PostMapping("/add-book-information")
	public int addBookInformation(@RequestBody Books book) throws BookNameException {
		return booksDaoImpl.addBooksInformation(book);
	}
	
	@DeleteMapping("/book/{book_id}")
	public int deleteBookInformationById(@PathVariable int book_id) {
		return booksDaoImpl.deleteBookInformation(book_id);
	}
	
	@DeleteMapping("/delete-all-books")
	public int deleteAllBookInformation() {
		return booksDaoImpl.deleteAllBookInformation();
	}
}
