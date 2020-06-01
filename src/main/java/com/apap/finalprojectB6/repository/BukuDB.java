package com.apap.finalprojectB6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

import com.apap.finalprojectB6.model.BukuModel;

public interface BukuDB extends JpaRepository<BukuModel, Integer>{
	BukuModel findById(int id);
	BukuModel deleteById(int id);

	@Query(value = "SELECT * FROM buku WHERE deleted_at IS NULL", nativeQuery = true)
	public ArrayList<BukuModel> getAllBuku();

}
