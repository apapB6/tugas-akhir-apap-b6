package com.apap.finalprojectB6.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class UserSivitasModel {
	private String idUser;
    private String nip;
    private String nama;
    private String tempatLahir;
    private String tanggalLahir;
    private String alamat;
    private String telepon;
        
    public String dateConverter(Date date) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String conv = formatter.format(date);
        return conv;
    }
    
    public UserSivitasModel() {
    	
    }
    
    public UserSivitasModel(UserModel user) {
    	this.idUser = user.getUuid();
    	this.nip = user.getNip();
    	this.nama = user.getNama();
    	this.tempatLahir = user.getTempat_lahir();
    	this.tanggalLahir = dateConverter(user.getTanggal_lahir());
    	this.alamat = user.getAlamat();
    	this.telepon = user.getTelepon();
    }

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public String getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
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
    
}
