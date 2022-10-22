package com.deguzman.DeGuzmanStuffAnywhere.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.deguzman.DeGuzmanStuffAnywhere.daoimpl.BooksDaoImpl;
import com.deguzman.DeGuzmanStuffAnywhere.exception.DuplicateBookNameException;
import com.deguzman.DeGuzmanStuffAnywhere.exception.ResourceNotFoundException;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_dao.BooksJpaDao;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Books;
import com.deguzman.DeGuzmanStuffAnywhere.util.AppConstants;
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

@Service
public class BooksService {

	@Autowired
	private BooksJpaDao booksJpaDao;
	
	@Autowired
	private BooksDaoImpl booksDaoImpl;

	public BooksListResponse findAllBookInformation() {
		BooksListResponse response = new BooksListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Books> list = new ArrayList();
		
		list = booksDaoImpl.findAllBooksInformation();
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_BOOKS_LIST_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_BOOKS_LIST_MSG);
		
		return response;
	}
	
	public ResponseEntity<Map<String, Object>> getAllBooksPagination(@RequestParam(required = false) String title,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		try {

			List<Books> shop = booksJpaDao.findAll();

			Pageable paging = PageRequest.of(page, size);

			Page<Books> pageBooks = null;

			if (title == null) {
				pageBooks = booksJpaDao.findAll(paging);
			} else {
				// pageBooks = autoShopDao.findByNameContaining(autoShopname, paging);
			}

			shop = pageBooks.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("books", shop);
			response.put("currentPage", pageBooks.getNumber());
			response.put("totalItems", pageBooks.getTotalElements());
			response.put("totalPages", pageBooks.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);
		}

		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public BooksListResponse findAllBooksByAuthor(BookSearchByAuthorRequest request) {
		BooksListResponse response = new BooksListResponse();
		List<com.deguzman.DeGuzmanStuffAnywhere.model.Books> list = new ArrayList();
		
		list = booksDaoImpl.findAllBooksByAuthor(request.getAuthor());
		response.setList(list);
		response.setSize(list.size());
		response.setDescription(AppConstants.GET_BOOK_LIST_BY_AUTHOR_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.GET_BOOK_LIST_BY_AUTHOR_MSG);
		
		return response;
	}
	
	public BookSearchResponse findBookInfomrationById(BookSearchByIdRequest request) throws ResourceNotFoundException {
		BookSearchResponse response = new BookSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Books book = booksDaoImpl.findBooksInformationById(request.getBookId());
		
		response.setBook(book);
		response.setDescription(AppConstants.FIND_BOOK_BY_ID_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.FIND_BOOK_BY_ID_MSG);
		
		return response;
	}
	
	public BookSearchResponse findBookInformationByName(BookSearchByTitleRequest request) {
		BookSearchResponse response = new BookSearchResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Books book = booksDaoImpl.findBookInformationByName(request.getTitle());
		
		response.setBook(book);
		response.setDescription(AppConstants.FIND_BOOK_BY_TITLE_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.FIND_BOOK_BY_TITLE_MSG);
		
		return response;
	}
	
	public long getBookCount() {
		return booksDaoImpl.getBookCount();
	}
	
	public BooksAddResponse addBooksInformation(BooksAddRequest request) throws DuplicateBookNameException {
		BooksAddResponse response = new BooksAddResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Books book = new com.deguzman.DeGuzmanStuffAnywhere.model.Books();
		
		book.setTitle(request.getTitle());
		book.setAuthor(request.getAuthor());
		book.setDescr(request.getDescr());
		
		int result = booksDaoImpl.addBooksInformation(request);
		
		response.setBooks(book);
		response.setRecordsAdded(result);
		response.setDescription(AppConstants.ADD_BOOK_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.ADD_BOOK_INFORMATION_MSG);
		
		return response;
	}
	
	public BooksUpdateResponse updateBooksInformation(BooksUpdateRequest request) {
		BooksUpdateResponse response = new BooksUpdateResponse(); 
		com.deguzman.DeGuzmanStuffAnywhere.model.Books book = new com.deguzman.DeGuzmanStuffAnywhere.model.Books();
		int updatedRecords = booksDaoImpl.updateBooksInformation(request.getBook_id(), request);
		
		response.setBooks(book);
		response.setUpdatedCount(updatedRecords);
		response.setDescription(AppConstants.UPDATE_BOOK_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.UPDATE_BOOK_INFORMATION_MSG);
		
		return response;
	}
	
	public BooksDeleteByIdResponse deleteBookInformation(BooksDeleteByIdRequest request) throws ResourceNotFoundException {
		BooksDeleteByIdResponse response = new BooksDeleteByIdResponse();
		com.deguzman.DeGuzmanStuffAnywhere.model.Books book = booksDaoImpl.findBooksInformationById(request.getBookId());
		int deletedRecords = booksDaoImpl.deleteBookInformation(request.getBookId());
		
		response.setBooks(book);
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_BOOK_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_BOOK_INFORMATION_MSG);
		
		return response;
	}
	
	public BooksDeleteAllResponse deleteAllBookInformation() {
		BooksDeleteAllResponse response = new BooksDeleteAllResponse();
		int deletedRecords = booksDaoImpl.deleteAllBookInformation();
		
		response.setDeleted(deletedRecords);
		response.setDescription(AppConstants.DELETE_ALL_BOOK_INFORMATION_DESCR);
		response.setStatusCode(String.valueOf(AppConstants.HTTP_STATUS_OK));
		response.setMessage(AppConstants.DELETE_ALL_BOOK_INFORMATION_MSG);
		
		return response;
	}
}
