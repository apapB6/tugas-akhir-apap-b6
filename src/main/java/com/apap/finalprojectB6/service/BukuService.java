package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.BukuModel;

public interface BukuService {
	BukuModel addBuku(BukuModel buku);
	List<BukuModel> getAllBuku();
	BukuModel getBukuById(int id);
	BukuModel updateBuku(int id, BukuModel buku);
	void updateJumlahKurang(int id, BukuModel buku);
	void updateJumlahTambah(int id, BukuModel buku);
	BukuModel deleteBuku(int id);

}
