package com.apap.finalprojectB6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.KoperasiModel;
import com.apap.finalprojectB6.repository.KoperasiDB;

@Service
@Transactional
public class KoperasiServiceImpl implements KoperasiService {
	@Autowired
	private KoperasiDB kopdb;
	
	@Override
	public KoperasiModel add(KoperasiModel kop) {
		return kopdb.save(kop);
	}
}
