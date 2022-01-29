package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.MedicalOffice;

@Repository
public interface MedicalOfficeJpaDao extends JpaRepository<MedicalOffice, Integer> {

	@Query(value = "SELECT * FROM medical_office WHERE name = ?1", nativeQuery = true)
	MedicalOffice findMedicalOfficeByName(String autoShopName);

	Page<MedicalOffice> findAll(Pageable pageable);

//	Page<AutoRepairShop> findByNameContaining(String name, Pageable pageable);
}
