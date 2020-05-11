package com.apap.finalprojectB6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.model.PengadaanModel;
import com.apap.finalprojectB6.model.UserModel;
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

	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	private List<PeminjamanModel> pengguna(Model model) {
		List<PeminjamanModel> peminjaman = peminjamanService.getAllPeminjaman();
		return peminjaman;
	}
	
	@GetMapping(value = "/detail/{id}")
	private PeminjamanModel detail(@PathVariable int id){
		PeminjamanModel peminjaman = peminjamanService.getPeminjamanById(id);
		peminjaman.setNama_peminjam(userService.getUserByUuid(peminjaman.getUuid_user()).getNama());
		// UserModel pengguna = new UserModel();
		// pengadaan.getUuid_user().add(userService.getUserByUuid(id));
		return peminjaman;
	}
	//
	// @RequestMapping(value = "/peminjaman/ubah/{id}", method = RequestMethod.GET)
	// private String update(@PathVariable(value = "id") int id, Model model) {
	// PeminjamanModel old = peminjamanService.getPeminjamanById(id);
	// List <UserModel> userList = userService.getAllUser();
	// String navigation = "Ubah Status Peminjaman";
	// model.addAttribute("navigation", navigation);
	// model.addAttribute("old", old);
	// model.addAttribute("user", userList);
	// model.addAttribute("new", new PeminjamanModel());
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "peminjaman/ubah-status-peminjaman";
	// }
	//
	// @RequestMapping(value = "/peminjaman/ubah/{id}", method = RequestMethod.POST)
	// private String update(@ModelAttribute PeminjamanModel newPeminjaman,
	// @PathVariable(value = "id") int id, Model model) {
	//// peminjamanService.getPeminjamanById_Buku(id);
	//// int id_buku =
	// (int)peminjamanService.getPeminjamanById_Buku(id).getPinjamBuku().getId();
	//// BukuModel buku = bukuService.getBukuById(id_buku);
	// peminjamanService.updatePeminjaman(id, newPeminjaman);
	// PeminjamanModel peminjaman = peminjamanService.getPeminjamanById(id);
	//// bukuService.updateJumlahTambah(id_buku, buku);
	// String navigation = "Berhasil";
	// model.addAttribute("navigation", navigation);
	// model.addAttribute("peminjaman", peminjaman);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "peminjaman/update-success";
	// }
	//
	// @RequestMapping(value = "/detail-peminjaman", method = RequestMethod.GET)
	// private String detail(@RequestParam(value = "id") int id, Model model) {
	// PeminjamanModel old = peminjamanService.getPeminjamanById(id);
	// String navigation = "Detail Buku";
	// model.addAttribute("navigation", navigation);
	// model.addAttribute("old", old);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "peminjaman/detail-peminjaman";
	// }
	//
	// @RequestMapping(value = "/peminjaman/hapus/{id}", method = RequestMethod.GET)
	// private String deleteUser(@PathVariable(value = "id") int id, Model model) {
	// PeminjamanModel old = peminjamanService.getPeminjamanById(id);
	// model.addAttribute("old",old);
	// String navigation = "Hapus Peminjaman";
	// model.addAttribute("navigation", navigation);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "peminjaman/hapus-peminjaman";
	// }
	//
	// @RequestMapping(value = "/peminjaman/hapus/{id}", method =
	// RequestMethod.POST)
	// private String delete(@PathVariable(value = "id") int id, Model model) {
	// peminjamanService.deletePeminjaman(id);
	// String navigation = "Berhasil";
	// model.addAttribute("navigation", navigation);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "peminjaman/delete-success";
	// }
}
