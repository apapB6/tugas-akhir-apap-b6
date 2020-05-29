package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.JenisModel;

public interface JenisService {
	List <JenisModel> getAllJenis();
	JenisModel getJenisById(int id);
	void addJenis(JenisModel jenis);
	void deleteJenis(int id);
}
