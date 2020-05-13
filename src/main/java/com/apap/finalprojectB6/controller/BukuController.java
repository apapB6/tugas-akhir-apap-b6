package com.apap.finalprojectB6.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.JenisModel;
import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.BukuService;
import com.apap.finalprojectB6.service.JenisService;
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

	//
	@GetMapping(value = "/detail/{id}")
	private BukuModel detail(@PathVariable int id) {
		BukuModel buku = bukuService.getBukuById(id);
		return buku;
	}

	@PostMapping(value = "/peminjaman/{id}")
	private PeminjamanModel detail1(@PathVariable int id) {
//			, @RequestBody PeminjamanModel peminjaman) {
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
		// HARDCODE
		peminjaman.setUuid_user("1");
		peminjaman.setNama_buku(buku.getJudul());
		peminjaman.setNama_peminjam(userService.getUserByUuid(peminjaman.getUuid_user()).getNama());
		bukuService.updateJumlahKurang(id, buku);
		return peminjamanService.addPeminjaman(peminjaman);
	}

	 @GetMapping(value = "/buku/ubah/{id}")
	 private BukuModel updateBuku(@PathVariable int id) {
		 BukuModel old = bukuService.getBukuById(id);
		 return old;
	 }
	
	 @PostMapping(value = "/buku/ubah/{id}")
	 private BukuModel updateBuku(@RequestBody BukuModel buku,
		 @PathVariable int id) {	 
//	 BukuModel buku = bukuService.getBukuById(id);
	 //userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		 return bukuService.updateBuku(id, buku);
	 }
	
	// @RequestMapping(value = "/buku/hapus/{id}", method = RequestMethod.GET)
	// private String deleteBuku(@PathVariable(value = "id") int id, Model model) {
	// BukuModel buku = bukuService.getBukuById(id);
	// model.addAttribute("buku", buku);
	// String navigation = "Hapus Buku";
	// model.addAttribute("navigation", navigation);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "buku/hapus-buku";
	// }
	//
	// @RequestMapping(value = "/buku/hapus/{id}", method = RequestMethod.POST)
	// private String delete(@PathVariable(value = "id") int id, Model model) {
	// bukuService.deleteBuku(id);
	// String navigation = "Berhasil";
	// model.addAttribute("navigation", navigation);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "buku/delete-success";
	// }
}
