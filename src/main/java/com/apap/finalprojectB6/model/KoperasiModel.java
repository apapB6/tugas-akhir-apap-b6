package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "koperasi")
public class KoperasiModel implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "username", nullable = false)
	private String username;
	
	@NotNull
	@Column(name = "jumlah_simpanan", nullable = false)
	private int jumlah_simpanan;
    
    @NotNull
    @Column(name = "id_role", nullable = false)
    private int id_role;

    /**
     * 
     * Getter&Setter
     */
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public int getJumlah_simpanan() {
		return jumlah_simpanan;
	}

	public void setJumlah_simpanan(int id_jenis_surat) {
		this.jumlah_simpanan = jumlah_simpanan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    

}
