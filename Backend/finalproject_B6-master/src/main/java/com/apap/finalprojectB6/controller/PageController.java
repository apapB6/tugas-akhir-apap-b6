package com.apap.finalprojectB6.controller;

import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.HomeModel;
import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.model.PengadaanModel;
import com.apap.finalprojectB6.service.BukuService;
import com.apap.finalprojectB6.service.PeminjamanService;
import com.apap.finalprojectB6.service.PengadaanService;

@RestController
@RequestMapping("/beranda")
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

	@RequestMapping("/")
	public HomeModel home(Model model) {
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		HomeModel home = new HomeModel();
		home.setJumlah_buku(bukuService.getAllBuku().size());
		home.setJumlah_pengadaan(pengadaanService.getAllPengadaan().size());
		home.setJumlah_pengguna(userService.getAllUser().size());		

		List<PeminjamanModel> loop = peminjamanService.getAllPeminjaman();
		for(int i = 0; i < loop.size(); i++) {
			if(loop.get(i).getStatus() == 5) {
				home.getPeminjaman().add(loop.get(i));
			}
		}

		return home;
		
	}
	
//	@RequestMapping("/login")
//	public String login () {
//		return "login";
//	}
//	
}
