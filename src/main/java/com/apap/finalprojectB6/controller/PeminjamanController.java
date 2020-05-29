package com.apap.finalprojectB6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.service.BukuService;
import com.apap.finalprojectB6.service.PeminjamanService;
import com.apap.finalprojectB6.service.UserService;

@RestController
@RequestMapping("/peminjaman")
@CrossOrigin(origins = "*")
public class PeminjamanController {
	@Autowired
	private PeminjamanService peminjamanService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private BukuService bukuService;

	@GetMapping(value = "/viewall")
	private List<PeminjamanModel> pengguna(Model model) {
		List<PeminjamanModel> peminjaman = peminjamanService.getAllPeminjaman();
		return peminjaman;
	}
	
	@GetMapping(value = "/detail/{id}")
	private PeminjamanModel detail(@PathVariable int id){
		PeminjamanModel peminjaman = peminjamanService.getPeminjamanById(id);
		peminjaman.setNama_peminjam(userService.getUserByUuid(peminjaman.getUuid_user()).getNama());
		return peminjaman;
	}

	@GetMapping(value = "/edit/{id}")
	private PeminjamanModel update(@PathVariable int id) {
		PeminjamanModel peminjaman = peminjamanService.getPeminjamanById(id);
		peminjaman.setNama_peminjam(userService.getUserByUuid(peminjaman.getUuid_user()).getNama());
		return peminjaman;
	}

	@PostMapping(value = "/edit/{id}")
	private PeminjamanModel update(@RequestBody PeminjamanModel peminjaman, @PathVariable int id) {
		BukuModel buku = bukuService.getBukuById(peminjaman.getId_buku());
		if(peminjaman.getStatus() == 5){
			peminjamanService.hitungHari(id, peminjaman);
			return peminjamanService.updateStatus(id, peminjaman);
		} else if ((peminjaman.getStatus() == 1) || (peminjaman.getStatus() == 4)){
			bukuService.updateJumlahTambah(peminjaman.getId_buku(), buku);
			return peminjamanService.updateStatus(id, peminjaman);
		}
		else {
		return peminjamanService.updateStatus(id, peminjaman);
		}
	}

}