package com.apap.finalprojectB6.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apap.finalprojectB6.service.UserService;

@RestController
@RequestMapping("/perpustakaan")
@CrossOrigin(origins = "*")
public class KoperasiRestController {
	@Autowired
	private UserService userService;

	
	@GetMapping(value = "/api/koperasi-employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllUser(Model model) 
	{	//url masih dummy
		String url = "https://webservice-situ.free.beeceptor.com/perpustakaan/user/viewall";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(url, String.class);	     
	    return result;
	}

}
