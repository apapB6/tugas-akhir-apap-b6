package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.KoperasiModel;
import com.apap.finalprojectB6.model.PengadaanModel;
import com.apap.finalprojectB6.repository.PengadaanDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PengadaanServiceImpl implements PengadaanService {
    @Autowired
	private PengadaanDB pengadaandb;

    @Override
    public List<PengadaanModel> getAllPengadaan(){
        return pengadaandb.findAll();
    }

    @Override
    public PengadaanModel getPengadaanById(int id){
        return pengadaandb.findById(id);
    }

    @Override
	public PengadaanModel addPengadaan(PengadaanModel pengadaan){
		return pengadaandb.save(pengadaan);
    }

    @Override
	public PengadaanModel deletePengadaan(int id) {
		return pengadaandb.deleteById(id);
	}

}