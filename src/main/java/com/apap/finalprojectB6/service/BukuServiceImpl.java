package com.apap.finalprojectB6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.JenisModel;
import com.apap.finalprojectB6.repository.BukuDB;


@Service
@Transactional
public class BukuServiceImpl implements BukuService {
	@Autowired
	private BukuDB bukudb;
	
	@Override
	public BukuModel addBuku(BukuModel buku) {
		return bukudb.save(buku);
	}

	
	@Override
	public List<BukuModel> getAllBuku() {
		List<BukuModel> allBuku = (List<BukuModel>) bukudb.findAll();
		return allBuku;
	}
	
	
	@Override
	public BukuModel getBukuById(int id) {
		return bukudb.findById(id);
	}
	
	@Override
	public BukuModel updateBuku(int id, BukuModel buku) {
		BukuModel old = this.getBukuById(id);
		old.setJumlah(buku.getJumlah());
		return bukudb.save(old);
	}
	
	@Override
	public void updateJumlahKurang(int id, BukuModel buku) {
		BukuModel old = this.getBukuById(id);
		old.setJumlah(buku.getJumlah()-1);
		bukudb.save(old);
	}
	
	@Override
	public void updateJumlahTambah(int id, BukuModel buku) {
		BukuModel old = this.getBukuById(id);
		old.setJumlah(buku.getJumlah()+1);
		bukudb.save(old);
	}
	
	@Override
	public void deleteBuku(int id) {
		bukudb.deleteById(id);
	}
}
