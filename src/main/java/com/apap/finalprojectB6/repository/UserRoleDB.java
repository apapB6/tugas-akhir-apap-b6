package com.apap.finalprojectB6.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.finalprojectB6.model.UserModel;

@Repository
public interface UserRoleDB extends JpaRepository<UserModel, Integer> {
	UserModel findByUsername(String username);
	UserModel findById(int id);
	UserModel findByUuid(String uuid);
	
	@Query(value = "SELECT * FROM pengguna WHERE username = ?1", nativeQuery = true)
	public ArrayList<UserModel> validate(String username);
	
	@Query(value = "SELECT username, id_role FROM pengguna", nativeQuery = true)
	public ArrayList<UserModel> userApi();
}
