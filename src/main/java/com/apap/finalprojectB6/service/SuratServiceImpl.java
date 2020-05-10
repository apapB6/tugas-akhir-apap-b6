package com.apap.finalprojectB6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.SuratModel;
import com.apap.finalprojectB6.repository.SuratDB;

@Service
@Transactional
public class SuratServiceImpl implements SuratService {
	@Autowired
	private SuratDB suratdb;
	
	@Override
	public SuratModel addSurat(SuratModel surat) {
		return suratdb.save(surat);
	}

}
