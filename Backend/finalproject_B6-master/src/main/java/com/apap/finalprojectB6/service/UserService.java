package com.apap.finalprojectB6.service;

import java.util.List;

import com.apap.finalprojectB6.model.UserModel;


public interface UserService {
<<<<<<< HEAD
//	UserModel addUser(UserModel user);
//	public String encrypt(String Password);
	List<UserModel> getAllUser();
	UserModel getUserById(int id);
	UserModel getUserByPass(String pass);
=======
	UserModel addUser(UserModel user);
//	public String encrypt(String Password);
	List<UserModel> getAllUser();
	UserModel getUserById(int id);
	UserModel getUserByUuid(String uuid);
	UserModel getUserByUsername(String username);
>>>>>>> 2fb8e35b368097eff3d56d45efd10d644c03a3b2
	void createNip(UserModel user);
	UserModel getUser(String user);
	boolean validate(String username);
}
