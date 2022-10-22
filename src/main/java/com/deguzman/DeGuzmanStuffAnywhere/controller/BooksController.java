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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateBookNameException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.service.BooksService;
import com.deguzman.DeGuzmanStuffAnywhere.util.UriConstants;
import com.deguzman.domain.BookSearchByAuthorRequest;
import com.deguzman.domain.BookSearchByIdRequest;
import com.deguzman.domain.BookSearchByTitleRequest;
import com.deguzman.domain.BookSearchResponse;
import com.deguzman.domain.BooksAddRequest;
import com.deguzman.domain.BooksAddResponse;
import com.deguzman.domain.BooksDeleteAllResponse;
import com.deguzman.domain.BooksDeleteByIdRequest;
import com.deguzman.domain.BooksDeleteByIdResponse;
import com.deguzman.domain.BooksListResponse;
import com.deguzman.domain.BooksUpdateRequest;
import com.deguzman.domain.BooksUpdateResponse;
import com.deguzman.domain.SuccessResponse;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/books")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BooksController {
	
	@Autowired
	private BooksService bookService;

	@GetMapping(value = UriConstants.URI_GET_BOOKS_LIST)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<BooksListResponse>> getAllBooksInformation() {
		BooksListResponse response = bookService.findAllBookInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_BOOKS_LIST_PAGINATION)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<Map<String, Object>> getAllBooksPagination(@RequestParam(required = false) String name,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		return bookService.getAllBooksPagination(name, page, size);
	}

	@GetMapping(value = UriConstants.URI_GET_BOOKS_BY_AUTHOR)
	@CrossOrigin(origins = "*", maxAge = 3600)
	public ResponseEntity<SuccessResponse<BooksListResponse>> getBooksInformationByAuthor(@RequestBody BookSearchByAuthorRequest request) {
		BooksListResponse response = bookService.findAllBooksByAuthor(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_BOOKS_BY_ID)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<BookSearchResponse>> getBookInformationById(@RequestBody BookSearchByIdRequest request) throws ResourceNotFoundException {
		BookSearchResponse response = bookService.findBookInfomrationById(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@GetMapping(value = UriConstants.URI_GET_BOOKS_BY_TITLE)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<BookSearchResponse>> getBookInformationByName(@RequestBody BookSearchByTitleRequest request) {
		BookSearchResponse response = bookService.findBookInformationByName(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@PostMapping(value = UriConstants.URI_ADD_BOOKS_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<BooksAddResponse>> addBookInformation(@RequestBody BooksAddRequest request) throws DuplicateBookNameException {
		BooksAddResponse response = bookService.addBooksInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
	
	@PutMapping(value = UriConstants.URI_UPDATE_BOOKS_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<BooksUpdateResponse>> updateBookInformation(@RequestBody BooksUpdateRequest request) {
		BooksUpdateResponse response = bookService.updateBooksInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_BOOKS_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<BooksDeleteByIdResponse>> deleteBookInformationById(@RequestBody BooksDeleteByIdRequest request) throws ResourceNotFoundException {
		BooksDeleteByIdResponse response = bookService.deleteBookInformation(request);
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}

	@DeleteMapping(value = UriConstants.URI_DELETE_ALL_BOOKS_INFORMATION)
	@CrossOrigin
	public ResponseEntity<SuccessResponse<BooksDeleteAllResponse>> deleteAllBookInformation() {
		BooksDeleteAllResponse response = bookService.deleteAllBookInformation();
		return new ResponseEntity<>(new SuccessResponse<>(response), HttpStatus.OK);
	}
}
