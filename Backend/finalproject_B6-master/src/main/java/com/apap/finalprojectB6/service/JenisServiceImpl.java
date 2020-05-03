package com.apap.finalprojectB6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.JenisModel;
import com.apap.finalprojectB6.repository.JenisDB;



@Service
@Transactional
public class JenisServiceImpl implements JenisService {
	@Autowired
	private JenisDB jenisdb;

	
	@Override
	public List<JenisModel> getAllJenis() {
		return jenisdb.findAll();
	}
	
	@Override
	public JenisModel getJenisById(int id) {
		return jenisdb.findById(id);
	}

	@Override
	public void addJenis(JenisModel jenis){
		jenisdb.save(jenis);
	}

	@Override
	public void deleteJenis(int id){
		jenisdb.deleteById(id);
	}
}
