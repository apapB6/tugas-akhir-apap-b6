package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.UserModel;
import com.apap.finalprojectB6.model.UserWebServiceModel;


public interface UserService {
	UserModel addUser(UserModel user);
//	public String encrypt(String Password);
	List<UserModel> getAllUser();
	UserModel getUserById(int id);
	UserModel getUserByUuid(String uuid);
	UserModel getUserByUsername(String username);
//	void createNip(UserModel user);
	UserModel getUser(String user);
	boolean validate(String username);
	boolean addUserSivitas(UserModel user);
}
