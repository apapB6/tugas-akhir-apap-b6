package com.apap.finalprojectB6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
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
import org.springframework.web.client.RestTemplate;

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

	@GetMapping(value = "/profile/{uuid}")
	private UserModel profile(@PathVariable String uuid){
		UserModel profile = userService.getUserByUuid(uuid);
		return profile;
	}
	
	@GetMapping(value = "/viewall")
	private List<UserModel> pengguna(Model model) {
		List<UserModel> user = userService.getAllUser();
		return user;
	}
	
	@GetMapping(value = "/detail/{id}")
	private UserModel detail(@PathVariable int id){
		UserModel pengguna = userService.getUserById(id);
		return pengguna;
	}

	@PostMapping(value = "/add", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	private boolean addSubmit(@RequestBody UserModel pengguna) {	
		if (userService.validate(pengguna.getUsername())) {
			pengguna.setId_role(3);
			userService.addUser(pengguna);
			return true;
		} else {
			return false;
		}
	}
}
