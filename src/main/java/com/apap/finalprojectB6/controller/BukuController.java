package com.apap.finalprojectB6.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.sql.Date;
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
@RequestMapping("/buku")
@CrossOrigin(origins = "*")
public class BukuController {
	@Autowired
	private BukuService bukuService;

	@Autowired
	private PeminjamanService peminjamanService;

	@Autowired
	private UserService userService;

	@GetMapping(value = "/viewall")
	private List<BukuModel> view(Model model) {
		List<BukuModel> buku = bukuService.getAllBuku();
		return buku;
	}

	@PostMapping(value = "/add")
	private BukuModel addSubmit(@RequestBody BukuModel buku) {
		return bukuService.addBuku(buku);
	}

	@GetMapping(value = "/detail/{id}")
	private BukuModel detail(@PathVariable int id) {
		BukuModel buku = bukuService.getBukuById(id);
		return buku;
	}

	@PostMapping(value = "/peminjaman/{id}", consumes = "text/plain")
	private PeminjamanModel addpeminjaman(@RequestBody String uuid_user, @PathVariable int id) {
		PeminjamanModel peminjaman = new PeminjamanModel();
		BukuModel buku = bukuService.getBukuById(id);
		LocalDate today = LocalDate.now();
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		Date date = Date.valueOf(today);
		Date duedate = Date.valueOf(nextWeek);
		peminjaman.setId_buku(buku.getId());
		peminjaman.setStatus(0);
		peminjaman.setTanggal_peminjaman(date);
		peminjaman.setTanggal_pengembalian(duedate);
		peminjaman.setNama_buku(buku.getJudul());
		// peminjaman.setNama_peminjam(userService.getUserByUuid(peminjaman.getUuid_user()).getNama());
		peminjaman.setUuid_user(uuid_user);
		peminjaman.setNama_peminjam(userService.getUserByUuid(uuid_user).getNama());
		bukuService.updateJumlahKurang(id, buku);
		return peminjamanService.addPeminjaman(peminjaman);
	}

	@GetMapping(value = "/edit/{id}")
	private BukuModel updateBuku(@PathVariable int id) {
		BukuModel buku = bukuService.getBukuById(id);
		return buku;
	}

	@PostMapping(value = "/edit/{id}")
	private BukuModel updateBuku(@RequestBody BukuModel buku, @PathVariable int id) {
		return bukuService.updateBuku(id, buku);
	}

	@GetMapping(value = "/delete/{id}")
	private BukuModel deleteBuku(@PathVariable int id) {
		BukuModel buku = bukuService.getBukuById(id);
		return buku;
	}

	@PostMapping(value = "/delete/{id}")
	private Boolean delete(@PathVariable int id) {
		BukuModel buku = bukuService.getBukuById(id);
		List<PeminjamanModel> peminjaman = peminjamanService.getAllPeminjaman();
		for(int i=0; i<peminjaman.size(); i++) {
			if(buku.getJudul().equals(peminjaman.get(i).getNama_buku())) {
				if((peminjaman.get(i).getNama_buku() == 1) || (peminjaman.get(i).getNama_buku() == 4)){
					break;
				}else{
					return false;
				}
			} else {
				continue;
			}
		} bukuService.deleteBuku(id);
		return true;
	}
}
