package com.apap.finalprojectB6.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apap.finalprojectB6.model.PengajuanSuratModel;

@Service
@Transactional
public class SuratServiceImpl implements SuratService {
	
	@Override
	public PengajuanSuratModel addSurat(PengajuanSuratModel surat) {
		final String url = "https://backend-situ.herokuapp.com";
		LocalDate today = LocalDate.now();
		Date datetoday = Date.valueOf(today);
		RestTemplate restTemplate = new RestTemplate();
			PengajuanSuratModel newSurat = new PengajuanSuratModel("-", datetoday, null, "Overdue Peminjaman Buku", 0, 5, "1");
			PengajuanSuratModel result = restTemplate.postForObject((url+"//pengajuan-surat/add"), newSurat, PengajuanSuratModel.class);
			return result;
	}
}
