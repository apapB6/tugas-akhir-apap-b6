package com.apap.finalprojectB6.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.repository.BukuDB;
import com.apap.finalprojectB6.repository.PeminjamanDB;


@Service
@Transactional
public class PeminjamanServiceImpl implements PeminjamanService {
	@Autowired
	private PeminjamanDB peminjamandb;
	
	@Override
	public void addPeminjaman(PeminjamanModel pinjam) {
		peminjamandb.save(pinjam);
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
	public void updatePeminjaman(int id, PeminjamanModel pinjam) {
		PeminjamanModel old = this.getPeminjamanById(id);
		old.setStatus(pinjam.getStatus());
		if(pinjam.getStatus() == 5) {
			this.hitungHari(id, pinjam);
		}
		peminjamandb.save(old);
	}
	
	@Override
	public void deletePeminjaman(int id) {
		peminjamandb.deleteById(id);
	}
	
	@Override
	public void hitungHari(int id, PeminjamanModel peminjaman) {
		PeminjamanModel old = this.getPeminjamanById(id);
		LocalDate today = LocalDate.now();
		Date date = Date.valueOf(today);
		Period period = Period.between(peminjaman.getTanggal_pengembalian().toLocalDate(), today);
	    int diff = period.getDays();
		old.setJumlah_hari(diff);
		old.setDenda(1000*(diff));
		peminjamandb.save(old);
	}
}
