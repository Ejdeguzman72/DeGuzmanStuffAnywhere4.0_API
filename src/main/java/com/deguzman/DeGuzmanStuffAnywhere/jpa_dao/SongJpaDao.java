package com.deguzman.DeGuzmanStuffAnywhere.jpa_dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.MedicalOffice;
import com.deguzman.DeGuzmanStuffAnywhere.jpa_model.Song;

@Repository
public interface SongJpaDao extends JpaRepository<Song, Integer> {

	@Query(value = "SELECT * FROM song WHERE title = ?1", nativeQuery=true)
	MedicalOffice findPersonByName(String title);

	Page<Song> findAll(Pageable pageable);

//	Page<AutoRepairShop> findByNameContaining(String name, Pageable pageable);
}
