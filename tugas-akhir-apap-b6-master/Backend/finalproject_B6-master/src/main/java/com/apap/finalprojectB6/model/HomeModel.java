package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Entity
//@Table(name = "home")
public class HomeModel implements Serializable{
   
//    @NotNull
//    @Column(name = "jumlah_pengadaan", nullable = false)
    private int jumlah_pengadaan;
    
//    @NotNull
//    @Column(name = "jumlah_buku", nullable = false)
    private int jumlah_buku;
    
//    @NotNull
//    @Column(name = "jumlah_pengguna", nullable = false)
    private int jumlah_pengguna;
    
    List<PeminjamanModel> peminjaman = new ArrayList<PeminjamanModel>();
    List<UserModel> nama_peminjam = new ArrayList<UserModel>();
    List<BukuModel> nama_buku = new ArrayList<BukuModel>();

	public int getJumlah_pengadaan() {
		return jumlah_pengadaan;
	}

	public void setJumlah_pengadaan(int jumlah_pengadaan) {
		this.jumlah_pengadaan = jumlah_pengadaan;
	}

	public int getJumlah_buku() {
		return jumlah_buku;
	}

	public void setJumlah_buku(int jumlah_buku) {
		this.jumlah_buku = jumlah_buku;
	}

	public int getJumlah_pengguna() {
		return jumlah_pengguna;
	}

	public void setJumlah_pengguna(int jumlah_pengguna) {
		this.jumlah_pengguna = jumlah_pengguna;
	}

	public List<PeminjamanModel> getPeminjaman() {
		return peminjaman;
	}

	public void setPeminjaman(List<PeminjamanModel> peminjaman) {
		this.peminjaman = peminjaman;
	}

	public List<UserModel> getNama_peminjam() {
		return nama_peminjam;
	}

	public void setNama_peminjam(List<UserModel> nama_peminjam) {
		this.nama_peminjam = nama_peminjam;
	}

	public List<BukuModel> getNama_buku() {
		return nama_buku;
	}

	public void setNama_buku(List<BukuModel> nama_buku) {
		this.nama_buku = nama_buku;
	}
	
}
