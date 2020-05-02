package com.apap.finalprojectB6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.finalprojectB6.model.RoleModel;

@Repository
public interface RoleDB extends JpaRepository<RoleModel, Integer> {
	RoleModel findByNama(String nama);
	RoleModel findById(int id);

}
