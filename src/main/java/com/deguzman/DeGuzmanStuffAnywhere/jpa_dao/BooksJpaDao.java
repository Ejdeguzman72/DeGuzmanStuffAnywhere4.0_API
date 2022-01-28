package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Books;

@Repository
public interface BooksJpaDao extends JpaRepository<Books, Integer> {

	@Query(value = "SELECT * FROM books WHERE name = ?1", nativeQuery=true)
	Books findBooksByName(String autoShopName);

	Page<Books> findAll(Pageable pageable);

//	Page<AutoRepairShop> findByNameContaining(String name, Pageable pageable);
}
