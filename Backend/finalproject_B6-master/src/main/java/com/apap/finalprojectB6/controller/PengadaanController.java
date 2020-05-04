<<<<<<< HEAD
//package com.apap.finalprojectB6.controller;
//
//import java.util.List;
//
//import com.apap.finalprojectB6.model.PengadaanModel;
//import com.apap.finalprojectB6.model.UserModel;
//import com.apap.finalprojectB6.service.PengadaanService;
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
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class PengadaanController {
//    @Autowired
//	private PengadaanService pengadaanService;
//	
//    @Autowired
//    private UserService userService;
//    
//    @RequestMapping(value = "/pengadaan", method = RequestMethod.GET)
//	private String index(Model model) {
//		List<PengadaanModel> pengadaan = pengadaanService.getAllPengadaan();
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//		model.addAttribute("pengadaan", pengadaan);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "pengadaan/index";
//	}
//
//	@RequestMapping(value = "/pengadaan/detail", method = RequestMethod.GET)
//	private String view(@RequestParam(value = "id") int id, Model model){
//		PengadaanModel pengadaan = pengadaanService.getPengadaanById(id);
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//		model.addAttribute("pengadaan", pengadaan);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "pengadaan/detail";
//	}
//	
//	@RequestMapping(value = "/pengadaan/tambah", method = RequestMethod.GET)
//	private String add(Model model){
//		UserModel user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//		model.addAttribute("user", user);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "pengadaan/addForm";
//	}
//
//	@RequestMapping(value = "/pengadaan/tambah", method = RequestMethod.POST)
//	private String addSubmit(@ModelAttribute PengadaanModel pengadaan, Model model){
//		UserModel user = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		pengadaan.setUser_pengadaan(user);
//		pengadaan.setStatus(1);
//		pengadaanService.addPengadaan(pengadaan);
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//        String typeMsg = "add";
//        model.addAttribute("typeMsg", typeMsg);
//        String msg = "Pengadaan Berhasil Diajukan!";
//        model.addAttribute("msg", msg);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "pengadaan/notif";
//	}
//
//	@RequestMapping(value = "pengadaan/hapus/{id}")
//	public String delete(@PathVariable(value = "id") int id, Model model){
//		pengadaanService.deletePengadaan(id);
//		String navigation = "SIP";
//		model.addAttribute("navigation", navigation);
//        String typeMsg = "add";
//        model.addAttribute("typeMsg", typeMsg);
//        String msg = "Pengadaan Berhasil Diajukan!";
//        model.addAttribute("msg", msg);
//		UserModel detailUser = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
//		model.addAttribute("detailUser", detailUser);
//		return "pengadaan/notif";
//	}
//}
=======
package com.apap.finalprojectB6.controller;

import java.util.List;

import com.apap.finalprojectB6.model.PengadaanModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.PengadaanService;
import com.apap.finalprojectB6.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//
@RestController
@RequestMapping("/pengadaan")
@CrossOrigin(origins = "*")
public class PengadaanController {
	@Autowired
	private PengadaanService pengadaanService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/viewall", method = RequestMethod.GET)
	private List<PengadaanModel> index(Model model) {
		List<PengadaanModel> pengadaan = pengadaanService.getAllPengadaan();
		// String navigation = "SIP";
		// model.addAttribute("navigation", navigation);
		// model.addAttribute("pengadaan", pengadaan);
		// UserModel detailUser =
		// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		// model.addAttribute("detailUser", detailUser);
		// return "pengadaan/index";
		return pengadaan;
	}
	//
	// @RequestMapping(value = "/pengadaan/detail", method = RequestMethod.GET)
	// private String view(@RequestParam(value = "id") int id, Model model){
	// PengadaanModel pengadaan = pengadaanService.getPengadaanById(id);
	// String navigation = "SIP";
	// model.addAttribute("navigation", navigation);
	// model.addAttribute("pengadaan", pengadaan);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "pengadaan/detail";
	// }
	//
	// @RequestMapping(value = "/pengadaan/tambah", method = RequestMethod.GET)
	// private String add(Model model){
	// UserModel user =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// String navigation = "SIP";
	// model.addAttribute("navigation", navigation);
	// model.addAttribute("user", user);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "pengadaan/addForm";
	// }
	//
	// @RequestMapping(value = "/pengadaan/tambah", method = RequestMethod.POST)
	// private String addSubmit(@ModelAttribute PengadaanModel pengadaan, Model
	// model){
	// UserModel user =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// pengadaan.setUser_pengadaan(user);
	// pengadaan.setStatus(1);
	// pengadaanService.addPengadaan(pengadaan);
	// String navigation = "SIP";
	// model.addAttribute("navigation", navigation);
	// String typeMsg = "add";
	// model.addAttribute("typeMsg", typeMsg);
	// String msg = "Pengadaan Berhasil Diajukan!";
	// model.addAttribute("msg", msg);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "pengadaan/notif";
	// }
	//
	// @RequestMapping(value = "pengadaan/hapus/{id}")
	// public String delete(@PathVariable(value = "id") int id, Model model){
	// pengadaanService.deletePengadaan(id);
	// String navigation = "SIP";
	// model.addAttribute("navigation", navigation);
	// String typeMsg = "add";
	// model.addAttribute("typeMsg", typeMsg);
	// String msg = "Pengadaan Berhasil Diajukan!";
	// model.addAttribute("msg", msg);
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "pengadaan/notif";
	// }
}
>>>>>>> 2fb8e35b368097eff3d56d45efd10d644c03a3b2
