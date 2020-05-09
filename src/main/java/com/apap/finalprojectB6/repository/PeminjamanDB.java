package com.apap.finalprojectB6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.PeminjamanModel;

public interface PeminjamanDB extends JpaRepository<PeminjamanModel, Integer>{
	PeminjamanModel findById(int id);
	PeminjamanModel findByStatus(int status);
	void deleteById(int id);
}
