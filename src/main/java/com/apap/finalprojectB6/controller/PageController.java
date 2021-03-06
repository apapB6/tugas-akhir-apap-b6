package com.apap.finalprojectB6.controller;

import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.finalprojectB6.model.HomeModel;
import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.service.BukuService;
import com.apap.finalprojectB6.service.PeminjamanService;
import com.apap.finalprojectB6.service.PengadaanService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
@Controller
public class PageController {
	@Autowired
	private PeminjamanService peminjamanService;

	@Autowired
    private UserService userService;
	
	@Autowired
    private PengadaanService pengadaanService;
	
	@Autowired
    private BukuService bukuService;

	@GetMapping("beranda")
	public HomeModel home(Model model) {
		HomeModel home = new HomeModel();
		home.setJumlah_buku(bukuService.getAllBuku().size());
		home.setJumlah_pengadaan(pengadaanService.getAllPengadaan().size());
		home.setJumlah_pengguna(userService.getAllUser().size());
		home.setJumlah_peminjaman(peminjamanService.getAllPeminjaman().size());		

		List<PeminjamanModel> loop = peminjamanService.getAllPeminjaman();
		for(int i = 0; i < loop.size(); i++) {
			if(loop.get(i).getStatus() == 5) {
				home.getPeminjaman().add(loop.get(i));
				home.getNama_buku().add(bukuService.getBukuById(loop.get(i).getId_buku()));
				home.getNama_peminjam().add(userService.getUserByUuid(loop.get(i).getUuid_user()));
			}
		}

		return home;
		
	}

	@GetMapping({ "hello" })
	public List<UserModel> firstPage(){
		List<UserModel> user = userService.getAllUser();
		return user;
	}
		
}
