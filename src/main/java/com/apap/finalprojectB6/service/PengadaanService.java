package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.KoperasiModel;
import com.apap.finalprojectB6.model.PengadaanModel;

public interface PengadaanService {
	List<PengadaanModel> getAllPengadaan();
	PengadaanModel getPengadaanById(int id);
	PengadaanModel addPengadaan(PengadaanModel pengadaan);
	PengadaanModel deletePengadaan(int id);
//	PengadaanModel cekUser(KoperasiModel koperasi);
}