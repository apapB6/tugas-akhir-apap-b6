package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.PengadaanModel;

public interface PengadaanService {
	List<PengadaanModel> getAllPengadaan();
	PengadaanModel getPengadaanById(int id);

	void addPengadaan(PengadaanModel pengadaan);
	void deletePengadaan(int id);
}