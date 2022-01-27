package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.AutoRepairShop;

@Repository
public interface AutoRepairShopJpaDao extends JpaRepository<AutoRepairShop, Integer> {

	@Query(value = "SELECT * FROM auto_shop WHERE auto_shop_name = ?1", nativeQuery=true)
	AutoRepairShop findAutoShopsByName(String autoShopName);

	@Query(value = "SELECT * FROM auto_shop WHERE zip = ?1", nativeQuery=true)
	List<AutoRepairShop> findAutoRepairShopsByZip(String zip);

	Page<AutoRepairShop> findAll(Pageable pageable);

//	Page<AutoRepairShop> findByNameContaining(String name, Pageable pageable);
}
