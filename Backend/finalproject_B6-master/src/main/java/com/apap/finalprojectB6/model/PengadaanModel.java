package com.apap.finalprojectB6.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pengadaan_buku")
public class PengadaanModel implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
    @NotNull
    @Size(max = 200)
    @Column(name = "judul", nullable = false)
    private String judul;

    
    @NotNull
    @Size(max = 200)
    @Column(name = "pengarang", nullable = false)
    private String pengarang;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "penerbit", nullable = false)
    private String penerbit;
    
    @NotNull
    @Column(name = "jumlah", nullable = false)
    private int jumlah;
    
    @NotNull
    @Column(name = "harga", nullable = false)
    private int harga;
    
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;
    
    @NotNull
//    @Size(max = 200)
    @Column(name = "uuid_user", nullable = false)
    private int uuid_user;
    
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "uuid_user", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private UserModel user_pengadaan;
    
    /**
     * Getter&Setter
     */
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getPengarang() {
		return pengarang;
	}

	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}

	public String getPenerbit() {
		return penerbit;
	}

	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUuid_user() {
		return uuid_user;
	}

	public void setUuid_user(int uuid_user) {
		this.uuid_user = uuid_user;
	}

//	public UserModel getUser_pengadaan() {
//		return user_pengadaan;
//	}
//
//	public void setUser_pengadaan(UserModel user_pengadaan) {
//		this.user_pengadaan = user_pengadaan;
//	}
    
    
}
