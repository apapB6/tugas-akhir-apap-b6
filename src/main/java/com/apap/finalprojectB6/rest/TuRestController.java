package com.apap.finalprojectB6.rest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.apap.finalprojectB6.model.PengajuanSuratModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.model.UserSivitasModel;
import com.apap.finalprojectB6.model.UserWebServiceModel;
import com.apap.finalprojectB6.service.RoleService;
import com.apap.finalprojectB6.service.UserService;

//
//
@RestController
@RequestMapping("/perpustakaan")
@CrossOrigin(origins = "*")
public class TuRestController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "api/employees")
	private List<UserWebServiceModel> pengguna() {
		List<UserModel> user = userService.getAllUser();
		ArrayList<UserWebServiceModel> restUser = new ArrayList<UserWebServiceModel>();
			for(int i = 0; i<user.size(); i++) {
				UserWebServiceModel getuser = new UserWebServiceModel(user.get(i).getUsername(), user.get(i).getId_role());
				restUser.add(getuser);
			}
		return restUser;
	}
	
	 @PostMapping(value = "api/add-surat", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	 public PengajuanSuratModel createSurat(@RequestBody PengajuanSuratModel surat) 
	 {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		Date datetoday = Date.valueOf(today);
		Date datetomorrow = Date.valueOf(tomorrow);
		
		final String url = "https://backend-si.herokuapp.com/pengajuan-surat/add";
//		final String url = "https://webservice-situ.free.beeceptor.com/tu/pengajuan-surat";
		
		RestTemplate restTemplate = new RestTemplate();
		surat = new PengajuanSuratModel("-", datetoday, datetomorrow, "Overdue Peminjaman Buku", 0, 5, "1"); 
	  	
	 	PengajuanSuratModel result = restTemplate.postForObject( url, surat, PengajuanSuratModel.class);
	 
	    return result;
	 }

}
