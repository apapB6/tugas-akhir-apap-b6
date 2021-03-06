package com.apap.finalprojectB6.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.finalprojectB6.model.KoperasiModel;
import com.apap.finalprojectB6.service.KoperasiService;
import com.apap.finalprojectB6.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class KoperasiRestController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private KoperasiService koperasiService;
	
	@GetMapping(value = "/dummy/koperasi-employees")
	private List<KoperasiModel> pengguna() {
		return koperasiService.getAllUser();
	}
	
	@GetMapping(value = "/koperasi-employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllUser() 
	{	//url masih dummy
		String url = "https://si-perpus-b6.herokuapp.com/api/dummy/koperasi-employees";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);	     
	    return result;
	}

}
