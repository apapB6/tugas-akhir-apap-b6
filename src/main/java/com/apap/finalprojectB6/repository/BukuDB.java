package com.apap.finalprojectB6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.finalprojectB6.model.BukuModel;

public interface BukuDB extends JpaRepository<BukuModel, Integer>{
	BukuModel findById(int id);
	BukuModel deleteById(int id);

}
