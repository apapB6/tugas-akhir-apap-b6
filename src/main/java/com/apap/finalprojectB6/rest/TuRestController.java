package com.apap.finalprojectB6.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.model.UserWebServiceModel;
import com.apap.finalprojectB6.service.UserService;
import com.apap.finalprojectB6.model.PengajuanSuratModel;
import com.apap.finalprojectB6.service.SuratService;
import org.springframework.util.MimeTypeUtils;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class TuRestController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private SuratService suratService;
	
	@GetMapping(value = "/employees")
	private List<UserWebServiceModel> pengguna() {
		List<UserModel> user = userService.getAllUser();
		ArrayList<UserWebServiceModel> restUser = new ArrayList<UserWebServiceModel>();
			for(int i = 0; i<user.size(); i++) {
				UserWebServiceModel getuser = new UserWebServiceModel(user.get(i).getUsername(), user.get(i).getId_role());
				restUser.add(getuser);
			}
		return restUser;
	}

	@PostMapping(value = "/add-surat", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	private PengajuanSuratModel addSubmit(@RequestBody PengajuanSuratModel surat) {	
		return suratService.addSurat(surat);
	}

}
