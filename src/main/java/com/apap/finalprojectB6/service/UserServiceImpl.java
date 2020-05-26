package com.apap.finalprojectB6.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.model.UserSivitasModel;
import com.apap.finalprojectB6.repository.UserRoleDB;

import java.util.UUID;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRoleDB userdb;
	
//	@Override
//	public void createNip(UserModel user) {
//		user.setNip(user.CreateNIP());
//	}
	
	@Override
	public UserModel addUser(UserModel user) {
		String pass = encrypt(user.getPassword());
		String uuid = UUID.randomUUID().toString().replace("-", "");
		UserModel uuidcheck = this.getUserByUuid(uuid);
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		String strDate= formatter.format(user.getTanggal_lahir());
		String nip = "P" + strDate + uuid;
		while (uuidcheck != null) {
			uuid = UUID.randomUUID().toString().replace("-", "");
		}
		user.setPassword(pass);
		user.setUuid(uuid);
		user.setNip(nip);
		addUserSivitas(user);
		return userdb.save(user);
	}
	
	public boolean addUserSivitas(UserModel user){
		final String url = "http://si-sivitas.herokuapp.com/api";
		RestTemplate restTemplate = new RestTemplate();
			UserSivitasModel newUser = new UserSivitasModel(user);
			UserSivitasModel result = restTemplate.postForObject( (url+"/employees"), newUser, UserSivitasModel.class);
			return true;
	}

	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
	}
	
	@Override
	public boolean validate(String username) {
		List<UserModel> userList = userdb.validate(username);
		if (userList.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public List<UserModel> getAllUser() {
		return userdb.findAll();
	}
	
	@Override
	public UserModel getUserById(int id) {
		return userdb.findById(id);
	}
	
	@Override
	public UserModel getUserByUuid(String uuid) {
		return userdb.findByUuid(uuid);
	}
	
	@Override
	public UserModel getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userdb.findByUsername(username);
	}

	@Override
	public UserModel getUser(String user) {
		return userdb.findByUsername(user);
	}

}
