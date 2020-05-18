package com.apap.finalprojectB6.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
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

import com.apap.finalprojectB6.model.BukuModel;
import com.apap.finalprojectB6.model.JenisModel;
import com.apap.finalprojectB6.model.PeminjamanModel;
import com.apap.finalprojectB6.model.SuratModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.service.BukuService;
import com.apap.finalprojectB6.service.JenisService;
import com.apap.finalprojectB6.service.PeminjamanService;
import com.apap.finalprojectB6.service.SuratService;
import com.apap.finalprojectB6.service.UserService;

@RestController
@RequestMapping("/surat")
@CrossOrigin(origins = "*")
public class SuratController {
	@Autowired
	private SuratService suratService;

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/add")
	private SuratModel addSubmit(@RequestBody SuratModel surat) {
		LocalDate today = LocalDate.now();
		Date date = Date.valueOf(today);
		surat.setId_jenis_surat(5);
		surat.setNomor_surat("-");
		surat.setStatus(0);
		surat.setKeterangan("Overdue Peminjaman Buku");
		//masih hardcode
		surat.setUuid_user("1");
		surat.setTanggal_pengajuan(date);
		return suratService.addSurat(surat);
	} 
}
