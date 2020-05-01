package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.apap.finalprojectB6.model.UserModel;

@Entity
@Table(name = "role")
public class RoleModel implements Serializable {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 200)
    @Column(name = "nama", nullable = false)
    private String nama;
    
    @OneToMany(mappedBy = "user_role", fetch = FetchType.LAZY)
    private Set<UserModel> userList = new HashSet<>();
    
    /**
     * Getter&Setter
     */
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public Set<UserModel> getUserList() {
		return userList;
	}

	public void setUserList(Set<UserModel> userList) {
		this.userList = userList;
	}
    
}
