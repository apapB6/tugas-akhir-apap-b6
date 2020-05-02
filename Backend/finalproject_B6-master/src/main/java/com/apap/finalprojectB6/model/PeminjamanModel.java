package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.apap.finalprojectB6.model.UserModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "peminjaman_buku")
public class PeminjamanModel implements Serializable {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uuid_user", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private UserModel user_peminjaman;
	
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_buku", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private BukuModel PinjamBuku;

    /**
     * Getter&Setter
     */
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UserModel getUser_peminjaman() {
		return user_peminjaman;
	}

	public void setUser_peminjaman(UserModel user_peminjaman) {
		this.user_peminjaman = user_peminjaman;
	}

	public BukuModel getPinjamBuku() {
		return PinjamBuku;
	}

	public void setPinjamBuku(BukuModel pinjamBuku) {
		PinjamBuku = pinjamBuku;
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

}
