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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.BooksDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.BookNameException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.model.Books;
import com.deguzman.DeGuzmanStuffAnywhere.service.BooksPaginationService;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BooksController {

	@Autowired
	private BooksDaoImpl booksDaoImpl;

	@Autowired
	private BooksPaginationService booksPageService;

	@GetMapping("/all")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<Books> getAllBooksInformation() {
		return booksDaoImpl.findAllBooksInformation();
	}

	@GetMapping("/all-books")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Map<String, Object>> getAllBooksPagination(@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return booksPageService.getAllBooksPagination(name, page, size);
	}

	@GetMapping("/book/artist/{author}")
	@CrossOrigin(origins = "*", maxAge = 3600)
	public List<Books> getBooksInformationByAuthor(@PathVariable String author) {
		return booksDaoImpl.findAllBooksByAuthor(author);
	}

	@GetMapping("/book/{book_id}")
	@CrossOrigin
	public ResponseEntity<Books> getBookInformationById(@PathVariable int book_id) throws ResourceNotFoundException {
		return booksDaoImpl.findBooksInformationById(book_id);
	}

	@GetMapping("/book/name/{name}")
	@CrossOrigin
	public ResponseEntity<Books> getBookInformationByName(@PathVariable String name) {
		return booksDaoImpl.findBookInformationByName(name);
	}

	@PostMapping("/add-book-information")
	@CrossOrigin
	public int addBookInformation(@RequestBody Books book) throws BookNameException {
		return booksDaoImpl.addBooksInformation(book);
	}
	
	@PutMapping("/book/{book_id}")
	@CrossOrigin
	public int updateBookInformation(@PathVariable int book_id, @RequestBody Books book) {
		return booksDaoImpl.updateBooksInformation(book_id, book);
	}

	@DeleteMapping("/book/{book_id}")
	@CrossOrigin
	public int deleteBookInformationById(@PathVariable int book_id) {
		return booksDaoImpl.deleteBookInformation(book_id);
	}

	@DeleteMapping("/delete-all-books")
	@CrossOrigin
	public int deleteAllBookInformation() {
		return booksDaoImpl.deleteAllBookInformation();
	}
}
