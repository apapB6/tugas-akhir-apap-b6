package com.apap.finalprojectB6.rest;

import java.util.List;

import com.apap.finalprojectB6.model.PengadaanModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.PengadaanService;
import com.apap.finalprojectB6.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apap.finalprojectB6.model.KoperasiModel;
import com.apap.finalprojectB6.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RuanganRestController {
	@Autowired
	private PengadaanService pengadaanService;

	@Autowired
	private UserService userService;

	@Autowired
	private KoperasiRestController koperasi;
	
	@PostMapping(value = "/add-pengadaan")
	private PengadaanModel addSubmit(@RequestBody PengadaanModel pengadaan){
		UserModel user = userService.getUserByUuid(pengadaan.getUuid_user());
		String[] cekUser = koperasi.getAllUser().split("[{,:\"}]");
		if(user.getId_role() == 5) {
			pengadaan.setStatus(1);		
		}else if (user.getId_role() == 3){
			for(int i= 0; i<cekUser.length; i++) {
				if(user.getUsername().equals(cekUser[i])){
					int simpanan = Integer.parseInt(cekUser[i+5]);
					if((cekUser[i+9].equals("6")) && (simpanan > 1000000)) {
						pengadaan.setStatus(3);
					}else {
						break;
					}
				}else {
					continue;
				}
			}
		}else {
			pengadaan.setStatus(0);
		}
		pengadaan.setNama(userService.getUserByUuid(pengadaan.getUuid_user()).getNama());
		return pengadaanService.addPengadaan(pengadaan);
	}

}
