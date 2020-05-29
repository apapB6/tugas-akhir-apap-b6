package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.UserModel;

public interface UserService {
	UserModel addUser(UserModel user);
	boolean addUserSivitas(UserModel user);
	public String encrypt(String Password);
	boolean validate(String username);
	List<UserModel> getAllUser();
	UserModel getUserById(int id);
	UserModel getUserByUuid(String uuid);
	UserModel getUserByUsername(String username);
//	void createNip(UserModel user);
	UserModel getUser(String user);
}
