package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.MedicalOffice;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Person;

@Repository
public interface PersonJpaDao extends JpaRepository<Person, Integer> {

	@Query(value = "SELECT * FROM person WHERE firstname = ?1", nativeQuery = true)
	MedicalOffice findPersonByName(String autoShopName);

	Page<Person> findAll(Pageable pageable);

//	Page<AutoRepairShop> findByNameContaining(String name, Pageable pageable);
}
