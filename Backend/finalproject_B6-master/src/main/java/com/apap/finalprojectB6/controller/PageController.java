//package com.apap.finalprojectB6.controller;
//
//import com.apap.finalprojectB6.model.UserModel;
//import com.apap.finalprojectB6.service.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.apap.finalprojectB6.model.BukuModel;
//import com.apap.finalprojectB6.model.PeminjamanModel;
//import com.apap.finalprojectB6.model.PengadaanModel;
//import com.apap.finalprojectB6.service.BukuService;
//import com.apap.finalprojectB6.service.PeminjamanService;
//import com.apap.finalprojectB6.service.PengadaanService;
//
//@Controller
//public class PageController {
//	@Autowired
//	private PeminjamanService peminjamanService;
//
//	@Autowired
//    private UserService userService;
//	
//	@Autowired
//    private PengadaanService pengadaanService;
//	
//	@Autowired
//    private BukuService bukuService;
//
//	@RequestMapping("/")
//	public String home(Model model) {
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		int jumlah_buku=bukuService.getAllBuku().size();
//		int jumlah_pengadaan=pengadaanService.getAllPengadaan().size();
//		int jumlah_pengguna=userService.getAllUser().size();
//		List<PeminjamanModel> peminjaman = new ArrayList<PeminjamanModel>();
//		List<PeminjamanModel> loop = peminjamanService.getAllPeminjaman();
//		for(int i = 0; i < loop.size(); i++) {
//			if(loop.get(i).getStatus() == 5) {
//				peminjaman.add(loop.get(i));
//				
//			}
//		}
//		model.addAttribute("peminjaman", peminjaman);
//		model.addAttribute("detailUser", detailUser);
//		model.addAttribute("jumlah_buku", jumlah_buku);
//		model.addAttribute("jumlah_pengadaan", jumlah_pengadaan);
//		model.addAttribute("jumlah_pengguna", jumlah_pengguna);
//		return "home";
//	}
//	
//	@RequestMapping("/login")
//	public String login () {
//		return "login";
//	}
//	
//}
