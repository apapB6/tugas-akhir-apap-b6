package com.apap.finalprojectB6.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apap.finalprojectB6.model.PengajuanSuratModel;
import com.apap.finalprojectB6.repository.SuratDB;



@Service
@Transactional
public class SuratServiceImpl implements SuratService {
	@Autowired
	private SuratDB suratdb;
	
	@Override
	public PengajuanSuratModel addSurat(PengajuanSuratModel surat) {
		createSuratTU(surat);
		return suratdb.save(surat);
	}
	
	public boolean createSuratTU(PengajuanSuratModel surat){
		final String url = "https://backend-situ.herokuapp.com";
		LocalDate today = LocalDate.now();
		Date datetoday = Date.valueOf(today);
		RestTemplate restTemplate = new RestTemplate();
			//uuid_user masih hardcode
			PengajuanSuratModel newSurat = new PengajuanSuratModel("-", datetoday, null, "Overdue Peminjaman Buku", 0, 5, null);
			PengajuanSuratModel result = restTemplate.postForObject((url+"//pengajuan-surat/add"), newSurat, PengajuanSuratModel.class);
			return true;
	}

}
//@PostMapping(value = "api/add-surat", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
//public PengajuanSuratModel createSurat(@RequestBody PengajuanSuratModel surat) 
//{
//	LocalDate today = LocalDate.now();
//	LocalDate tomorrow = today.plusDays(1);
//	Date datetoday = Date.valueOf(today);
//	Date datetomorrow = Date.valueOf(tomorrow);
//	
//	final String url = "https://backend-si.herokuapp.com/pengajuan-surat/add";
////	final String url = "https://webservice-situ.free.beeceptor.com/tu/pengajuan-surat";
//	
//	RestTemplate restTemplate = new RestTemplate();
//	surat = new PengajuanSuratModel("-", datetoday, datetomorrow, "Overdue Peminjaman Buku", 0, 5, "1"); 
// 	
//	PengajuanSuratModel result = restTemplate.postForObject( url, surat, PengajuanSuratModel.class);
//
//   return result;
//}