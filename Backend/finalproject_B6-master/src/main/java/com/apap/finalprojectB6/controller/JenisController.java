//package com.apap.finalprojectB6.controller;
//
//import java.util.List;
//
//import com.apap.finalprojectB6.model.JenisModel;
//import com.apap.finalprojectB6.model.UserModel;
//import com.apap.finalprojectB6.service.JenisService;
//import com.apap.finalprojectB6.service.UserService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class JenisController {
//    @Autowired
//	private JenisService jenisService;
//	
//	@Autowired
//	private UserService userService;
//    
//    @RequestMapping(value = "/jenis", method = RequestMethod.GET)
//	private String index(Model model) {
//		List<JenisModel> jenis = jenisService.getAllJenis();
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//		model.addAttribute("jenis", jenis);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "jenis_buku/index";
//    }
//    
//    @RequestMapping(value = "/jenis/tambah", method = RequestMethod.GET)
//    private String add(Model model){
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "jenis_buku/formAdd";
//	}
//	
//	@RequestMapping(value = "/jenis/tambah", method = RequestMethod.POST)
//	private String addSubmit(@ModelAttribute JenisModel jenis, Model model){
//		jenisService.addJenis(jenis);
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//        String typeMsg = "add";
//        model.addAttribute("typeMsg", typeMsg);
//        String msg = "Jenis Buku Berhasil Ditambahkan!";
//        model.addAttribute("msg", msg);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "jenis_buku/notif";
//	}
//
//	@RequestMapping(value = "/jenis/hapus/{id}")
//	public String delete(@PathVariable(value = "id") int id, Model model){
//		jenisService.deleteJenis(id);
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//        String typeMsg = "add";
//        model.addAttribute("typeMsg", typeMsg);
//        String msg = "Jenis Buku Berhasil Ditambahkan!";
//        model.addAttribute("msg", msg);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "jenis_buku/notif";
//	}
//
//}