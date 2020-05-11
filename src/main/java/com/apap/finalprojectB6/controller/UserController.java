package com.apap.finalprojectB6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
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

import com.apap.finalprojectB6.model.RoleModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.RoleService;
import com.apap.finalprojectB6.service.UserService;

//
//
@RestController
@RequestMapping("/pengguna")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	//
	// @RequestMapping(value = "/profile", method = RequestMethod.GET)
	// private String profil(Model model) {
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "profil/index";
	// }
	//
	@GetMapping(value = "/viewall")
	private List<UserModel> pengguna(Model model) {
		List<UserModel> user = userService.getAllUser();
		return user;
	}
	
	@GetMapping(value = "/getuser")
	private List<UserModel> getuser(Model model) {
		List<UserModel> user = userService.getUserApi();
		return user;
	}

	@GetMapping(value = "/detail/{id}")
	private UserModel detail(@PathVariable int id){
		UserModel pengguna = userService.getUserById(id);
		return pengguna;
	}

	// @RequestMapping(value = "/pengguna/tambah", method = RequestMethod.GET)
	// private String add(Model model) {
	// String navigation = "Tambah Pengguna";
	// model.addAttribute("navigation", navigation);
	// model.addAttribute("user", new UserModel());
	// UserModel detailUser =
	// userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
	// model.addAttribute("detailUser", detailUser);
	// return "pengguna/tambah-pengguna";
	// }
	//

	@PostMapping(value = "/add")
	private UserModel addSubmit(@RequestBody UserModel pengguna) {
		pengguna.setId_role(5);
		return userService.addUser(pengguna);
	}
	//
	//// @RequestMapping(value = "/viewbuku", method = RequestMethod.GET)
	//// private String detail(@RequestParam(value = "id") int id, Model model) {
	//// BukuModel buku = bukuService.getBukuById(id);
	//// String navigation = "Detail Buku";
	//// model.addAttribute("navigation", navigation);
	//// model.addAttribute("buku", buku);
	//// return "detail-buku";
	//// }
	////
	//// @RequestMapping(value = "/buku/ubah/{id}", method = RequestMethod.GET)
	//// private String updateUser(@PathVariable(value = "id") int id, Model model)
	// {
	//// BukuModel old = bukuService.getBukuById(id);
	//// List <JenisModel> jenisList = jenisService.getAllJenis();
	//// String navigation = "Ubah Buku";
	//// model.addAttribute("navigation", navigation);
	//// model.addAttribute("old", old);
	//// model.addAttribute("jenis_buku", jenisList);
	//// model.addAttribute("new", new BukuModel());
	//// return "ubah-buku";
	//// }
	////
	//// @RequestMapping(value = "/buku/ubah/{id}", method = RequestMethod.POST)
	//// private String updateUser(@ModelAttribute BukuModel newBuku,
	//// @PathVariable(value = "id") int id, Model model) {
	//// bukuService.updateBuku(id, newBuku);
	//// BukuModel buku = bukuService.getBukuById(id);
	//// String navigation = "Berhasil";
	//// model.addAttribute("navigation", navigation);
	//// model.addAttribute("buku", buku);
	//// return "update-success";
	//// }
	////
	//// @RequestMapping(value = "/buku/hapus/{id}", method = RequestMethod.GET)
	//// private String deleteUser(@PathVariable(value = "id") int id, Model model)
	// {
	//// BukuModel buku = bukuService.getBukuById(id);
	//// model.addAttribute("buku", buku);
	//// String navigation = "Hapus Buku";
	//// model.addAttribute("navigation", navigation);
	//// return "hapus-buku";
	//// }
	////
	//// @RequestMapping(value = "/buku/hapus/{id}", method = RequestMethod.POST)
	//// private String delete(@PathVariable(value = "id") int id, Model model) {
	//// bukuService.deleteBuku(id);
	//// String navigation = "Berhasil";
	//// model.addAttribute("navigation", navigation);
	//// return "delete-success";
	//// }
	//
}
