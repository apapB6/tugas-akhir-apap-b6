package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name = "surat")
public class PengajuanSuratModel implements Serializable {	
	private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		@NotNull
		@Size(max = 200)
		@Column(name = "nomor_surat", nullable = false)
		private String nomor_surat;

		@NotNull
		@Column(name = "tanggal_pengajuan", nullable = false)
		private Date tanggal_pengajuan;

		@Column(name = "tanggal_disetujui", nullable = true)
		private Date tanggal_disetujui;

		@NotNull
		@Size(max = 200)
		@Column(name = "keterangan", nullable = true)
		private String keterangan;

		@NotNull
		@Column(name = "status", nullable = false)
		private int status;

		@NotNull
		@Column(name = "id_jenis_surat", nullable = false)
		private int id_jenis_surat;

		@NotNull
		@Column(name = "uuid_user", nullable = true)
		private String uuid_user;

	public PengajuanSuratModel(String nomor_surat,  Date tanggal_pengajuan, Date tanggal_disetujui, String keterangan, int status, int id_jenis_surat, String uuid_user){
		this.nomor_surat = nomor_surat;
		this.tanggal_pengajuan = tanggal_pengajuan;
		this.tanggal_disetujui = tanggal_disetujui;
		this.keterangan = keterangan;
		this.status = status;
		this.id_jenis_surat = id_jenis_surat;
		this.uuid_user = uuid_user;
	}
	
	public PengajuanSuratModel() {
		
	}

	public String getNomor_surat() {
		return nomor_surat;
	}

	public void setNomor_surat(String nomor_surat) {
		this.nomor_surat = nomor_surat;
	}

	public String getUuid_user() {
		return uuid_user;
	}

	public void setUuid_user(String uuid_user) {
		this.uuid_user = uuid_user;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public Date getTanggal_pengajuan() {
		return tanggal_pengajuan;
	}

	public void setTanggal_pengajuan(Date tanggal_pengajuan) {
		this.tanggal_pengajuan = tanggal_pengajuan;
	}

	public Date getTanggal_disetujui() {
		return tanggal_disetujui;
	}

	public void setTanggal_disetujui(Date tanggal_disetujui) {
		this.tanggal_disetujui = tanggal_disetujui;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId_jenis_surat() {
		return id_jenis_surat;
	}

	public void setId_jenis_surat(int id_jenis_surat) {
		this.id_jenis_surat = id_jenis_surat;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
    

