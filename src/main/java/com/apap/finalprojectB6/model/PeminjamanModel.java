package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.apap.finalprojectB6.model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "peminjaman_buku")
public class PeminjamanModel implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull
    @Size(max = 200)
    @Column(name = "uuid_user", nullable = false)
    private String uuid_user;
	
    @NotNull
    @Column(name = "tanggal_peminjaman", nullable = false)
    private Date tanggal_peminjaman;
    
    @NotNull
    @Column(name = "tanggal_pengembalian", nullable = false)
    private Date tanggal_pengembalian;
	
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;
    
    @NotNull
    @Column(name = "jumlah_hari", nullable = false)
    private int jumlah_hari;
    
    @NotNull
    @Column(name = "denda", nullable = false)
    private int denda;
    
    @NotNull
    @Column(name = "id_buku", nullable = false)
    private int id_buku;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "nama_buku", nullable = false)
    private String nama_buku;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "nama_peminjam", nullable = false)
    private String nama_peminjam;
    
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "uuid_user", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private UserModel user_peminjaman;
//	
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_buku", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private BukuModel PinjamBuku;

    /**
     * Getter&Setter
     */
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getUuid_user() {
		return uuid_user;
	}

	public void setUuid_user(String uuid_user) {
		this.uuid_user = uuid_user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getTanggal_peminjaman() {
		return tanggal_peminjaman;
	}

	public void setTanggal_peminjaman(Date tanggal_peminjaman) {
		this.tanggal_peminjaman = tanggal_peminjaman;
	}

	public Date getTanggal_pengembalian() {
		return tanggal_pengembalian;
	}

	public void setTanggal_pengembalian(Date tanggal_pengembalian) {
		this.tanggal_pengembalian = tanggal_pengembalian;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getJumlah_hari() {
		return jumlah_hari;
	}

	public void setJumlah_hari(int jumlah_hari) {
		this.jumlah_hari = jumlah_hari;
	}

	public int getDenda() {
		return denda;
	}

	public void setDenda(int denda) {
		this.denda = denda;
	}

	public int getId_buku() {
		return id_buku;
	}

	public void setId_buku(int id_buku) {
		this.id_buku = id_buku;
	}

	public String getNama_buku() {
		return nama_buku;
	}

	public void setNama_buku(String nama_buku) {
		this.nama_buku = nama_buku;
	}

	public String getNama_peminjam() {
		return nama_peminjam;
	}

	public void setNama_peminjam(String nama_peminjam) {
		this.nama_peminjam = nama_peminjam;
	}

	
//	public UserModel getUser_peminjaman() {
//		return user_peminjaman;
//	}
//
//	public void setUser_peminjaman(UserModel user_peminjaman) {
//		this.user_peminjaman = user_peminjaman;
//	}
//
//	public BukuModel getPinjamBuku() {
//		return PinjamBuku;
//	}
//
//	public void setPinjamBuku(BukuModel pinjamBuku) {
//		PinjamBuku = pinjamBuku;
//	}
//
//	public int getJumlah_hari() {
//		return jumlah_hari;
//	}
//
//	public void setJumlah_hari(int jumlah_hari) {
//		this.jumlah_hari = jumlah_hari;
//	}
//
//	public int getDenda() {
//		return denda;
//	}
//
//	public void setDenda(int denda) {
//		this.denda = denda;
//	}

}
