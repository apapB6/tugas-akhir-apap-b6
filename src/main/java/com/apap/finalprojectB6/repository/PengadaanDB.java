package com.apap.finalprojectB6.repository;


import com.apap.finalprojectB6.model.PengadaanModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PengadaanDB extends JpaRepository<PengadaanModel, Integer>{
	PengadaanModel findById(int id);
	void deleteById(int id);
}