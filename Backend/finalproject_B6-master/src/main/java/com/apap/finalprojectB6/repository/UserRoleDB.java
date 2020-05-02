package com.apap.finalprojectB6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.finalprojectB6.model.UserModel;

@Repository
public interface UserRoleDB extends JpaRepository<UserModel, Integer> {
	UserModel findByUsername(String username);
	void deleteById(int id);
	UserModel findById(int id);
	UserModel findByPassword(String pass);
}
