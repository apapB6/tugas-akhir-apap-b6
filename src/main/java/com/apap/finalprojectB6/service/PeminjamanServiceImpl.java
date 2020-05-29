package com.apap.finalprojectB6.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.repository.PeminjamanDB;

@Service
@Transactional
public class PeminjamanServiceImpl implements PeminjamanService {
	@Autowired
	private PeminjamanDB peminjamandb;
	
	@Override
	public PeminjamanModel addPeminjaman(PeminjamanModel pinjam) {
		return peminjamandb.save(pinjam);
	}

	@Override
	public List<PeminjamanModel> getAllPeminjaman() {
		return peminjamandb.findAll();
	}
	
	@Override
	public PeminjamanModel getPeminjamanById(int id) {
		return peminjamandb.findById(id);
	}
	
	@Override
	public PeminjamanModel getPeminjamanByStatus(int status) {
		return peminjamandb.findByStatus(status);
	}
	
	@Override
	public PeminjamanModel updateStatus(int id, PeminjamanModel statusPeminjaman){
		PeminjamanModel peminjaman = this.getPeminjamanById(id);
		peminjaman.setStatus(statusPeminjaman.getStatus());
		return peminjamandb.save(peminjaman);
	}
	
	@Override
	public void deletePeminjaman(int id) {
		peminjamandb.deleteById(id);
	}
	
	@Override
	public void hitungHari(int id, PeminjamanModel peminjaman) {
		PeminjamanModel old = this.getPeminjamanById(id);
		LocalDate today = LocalDate.now();
		Period period = Period.between(peminjaman.getTanggal_pengembalian().toLocalDate(), today);
	    int diff = period.getDays();
		if(diff >= 0){
			old.setJumlah_hari(diff);
			old.setDenda(1000*(diff));
		}else{
			old.setJumlah_hari(0);
			old.setDenda(0);
		}
		peminjamandb.save(old);
	}
}
