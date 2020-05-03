package com.apap.finalprojectB6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.RoleModel;
import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.repository.UserRoleDB;


@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRoleDB userdb;
	
	@Override
	public void createNip(UserModel user) {
		user.setNip(user.CreateNIP());
	}
	
//	@Override
//	public UserModel addUser(UserModel user) {
//		String pass = encrypt(user.getPassword());
//		user.setPassword(pass);
//		this.createNip(user);
//		return userdb.save(user);
//	}
//	
//	@Override
//	public String encrypt(String password) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String hashedPassword = passwordEncoder.encode(password);
//		return hashedPassword;
//	}

	
	@Override
	public List<UserModel> getAllUser() {
		return userdb.findAll();
	}
	
	
	@Override
	public UserModel getUserById(int id) {
		return userdb.findById(id);
	}
	
	@Override
	public UserModel getUserByPass(String pass) {
		return userdb.findByPassword(pass);
	}

	@Override
	public UserModel getUser(String user) {
		return userdb.findByUsername(user);
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

}
