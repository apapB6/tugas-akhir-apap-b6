package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.sql.Date;

public class UserProfileModel implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private String nama;
	
	private String uuid;
	
	private String nip;

	private String tempat_lahir;

	private Date tanggal_lahir;

    private String alamat;
	
    private String telepon;
    
    /**
     * 
     * Getter&Setter
     */
        

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getTempat_lahir() {
		return tempat_lahir;
	}

	public void setTempat_lahir(String tempat_lahir) {
		this.tempat_lahir = tempat_lahir;
	}

	public Date getTanggal_lahir() {
		return tanggal_lahir;
	}

	public void setTanggal_lahir(Date tanggal_lahir) {
		this.tanggal_lahir = tanggal_lahir;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getTelepon() {
		return telepon;
	}

	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
      
}
