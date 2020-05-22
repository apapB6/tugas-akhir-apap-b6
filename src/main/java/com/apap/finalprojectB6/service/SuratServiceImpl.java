package com.apap.finalprojectB6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.model.UserSivitasModel;
import com.apap.finalprojectB6.repository.UserRoleDB;

import java.util.UUID;


//@Service
//@Transactional
//public class SuratServiceImpl implements SuratService {
//	@Autowired
//	private UserRoleDB userdb;
//	
//	@Override
//	public UserModel addSurat(UserModel surat) {
////		String pass = encrypt(user.getPassword());
//		String uuid = UUID.randomUUID().toString().replace("-", "");
//		UserModel uuidcheck = this.getUserByUuid(uuid);
//		while (uuidcheck != null) {
//			uuid = UUID.randomUUID().toString().replace("-", "");
//		}
////		user.setPassword(pass);
//		user.setUuid(uuid);
//		this.createNip(user);
//		addUserSivitas(user);
//		return userdb.save(user);
//	}

//}
