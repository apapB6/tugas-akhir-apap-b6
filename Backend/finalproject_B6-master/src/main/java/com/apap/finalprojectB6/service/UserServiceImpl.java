package com.apap.finalprojectB6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Override
	public UserModel addUser(UserModel user) {
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		this.createNip(user);
		return userdb.save(user);
	}
	
	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		return hashedPassword;
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
	public UserModel getUserByPass(String pass) {
		return userdb.findByPassword(pass);
	}
	
	@Override
	public void updateUser(int id, UserModel buku) {
//		UserModel old = this.getUserById(id);
//		old.setJudul(buku.getJudul());
//		old.setPengarang(buku.getPengarang());
//		old.setPenerbit(buku.getPenerbit());
//		old.setJumlah(buku.getJumlah());
//		old.setBuku_jenis(buku.getBuku_jenis());
//		userdb.save(old);
	}
	
	@Override
	public void deleteUser(int id) {
		userdb.deleteById(id);
	}

	@Override
	public UserModel getUser(String user) {
		return userdb.findByUsername(user);
	}

}
