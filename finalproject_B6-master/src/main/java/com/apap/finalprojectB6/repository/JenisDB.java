package com.apap.finalprojectB6.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.JenisModel;

public interface JenisDB extends JpaRepository<JenisModel, Long>{
	JenisModel findById(int id);
	void deleteById(int id);
}
