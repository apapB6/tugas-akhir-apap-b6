package com.apap.finalprojectB6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.finalprojectB6.model.RoleModel;
import com.apap.finalprojectB6.repository.RoleDB;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDB roledb;

	@Override
	public RoleModel getRoleByNama(String nama) {
		return roledb.findByNama(nama);
	}
	
	@Override
	public RoleModel getRoleById(int id) {
		return roledb.findById(id);
	}
}
