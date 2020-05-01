package com.apap.finalprojectB6.model;

import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "buku")
public class BukuModel implements Serializable {
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
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_jenis_buku")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JenisModel buku_jenis;
    
    //CEK ULANG
    @OneToMany(mappedBy = "PinjamBuku", fetch = FetchType.LAZY)
    private Set<PeminjamanModel> peminjamanList = new HashSet<>();

    /**
     * Getter&Setter
     */
    
	public long getId() {
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

	public JenisModel getBuku_jenis() {
		return buku_jenis;
	}

	public void setBuku_jenis(JenisModel bukuJenis) {
		this.buku_jenis = bukuJenis;
	}

	public Set<PeminjamanModel> getPeminjamanList() {
		return peminjamanList;
	}

	public void setPeminjamanList(Set<PeminjamanModel> peminjamanList) {
		this.peminjamanList = peminjamanList;
	}
    
}
