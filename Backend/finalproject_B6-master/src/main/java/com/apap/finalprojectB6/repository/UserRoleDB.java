package com.apap.finalprojectB6.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.finalprojectB6.model.UserModel;

@Repository
public interface UserRoleDB extends JpaRepository<UserModel, Integer> {
	UserModel findByUsername(String username);
<<<<<<< HEAD
	void deleteById(int id);
	UserModel findById(int id);
	UserModel findByPassword(String pass);
=======
	UserModel findById(int id);
	UserModel findByUuid(String uuid);
>>>>>>> 2fb8e35b368097eff3d56d45efd10d644c03a3b2
	
	@Query(value = "SELECT * FROM user_profile WHERE username = ?1", nativeQuery = true)
	public ArrayList<UserModel> validate(String username);
}
