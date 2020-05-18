package com.apap.finalprojectB6.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class SuratModel implements Serializable {	
	private static final long serialVersionUID = 1L;
	
    private int id;
	private String nomor_surat;
	private String uuid_user;
	private String keterangan;
	private Date tanggal_pengajuan;
	private Date tanggal_disetujui;
    private int status;
    private int id_jenis_surat;

	public SuratModel(String nomor_surat,  Date tanggal_pengajuan, Date tanggal_disetujui, String keterangan, int status, int id_jenis_surat, String uuid_user){
		this.nomor_surat = nomor_surat;
		this.tanggal_pengajuan = tanggal_pengajuan;
		this.tanggal_disetujui = tanggal_disetujui;
		this.keterangan = keterangan;
		this.status = status;
		this.id_jenis_surat = id_jenis_surat;
		this.uuid_user = uuid_user;
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
