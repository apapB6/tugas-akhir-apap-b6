package com.apap.finalprojectB6.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.finalprojectB6.model.UserWebServiceModel;

@Repository
public interface UserWebServiceDB extends JpaRepository<UserWebServiceModel, Integer> {

	
}
