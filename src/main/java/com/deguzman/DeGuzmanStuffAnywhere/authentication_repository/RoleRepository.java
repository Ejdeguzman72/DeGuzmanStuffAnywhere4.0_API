package com.deguzman.DeGuzmanStuffAnywhere.authentication_repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.ERole;
import com.deguzman.DeGuzmanStuffAnywhere.authentication_models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}