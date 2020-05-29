package com.apap.finalprojectB6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.finalprojectB6.model.SuratModel;

public interface SuratDB extends JpaRepository<SuratModel, Integer>{
	SuratModel findById(int id);
	void deleteById(int id);

}
