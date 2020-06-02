package com.apap.finalprojectB6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.finalprojectB6.model.PengajuanSuratModel;
import com.apap.finalprojectB6.service.SuratService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SuratController {
	@Autowired
	private SuratService suratService;

	@PostMapping(value = "/add-surat", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	private PengajuanSuratModel addSubmit(@RequestBody PengajuanSuratModel surat) {	
		return suratService.addSurat(surat);
	}
			
}
