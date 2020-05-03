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
@Table(name = "user")
public class UserModel implements Serializable {	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Type(type="uuid-char")
//	@Column(name="uuid", columnDefinition = "VARCHAR(200)", insertable = false, updatable = false, nullable = false)
//	private String uuid;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "nip", nullable = false, unique = true)
	private String nip;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "tempat_lahir")
	private String tempat_lahir;
	
	@NotNull
	@Column(name = "tanggal_lahir", nullable = false)
	private Date tanggal_lahir;
	
	@NotNull
    @Size(max = 200)
    @Column(name = "alamat", nullable = false)
    private String alamat;
	
	@NotNull
    @Size(max = 200)
    @Column(name = "telepon", nullable = false)
    private String telepon;
	
    @NotNull
    @Size(max = 200)
    @Column(name = "username", nullable = false)
    private String username;
    
    @NotNull
    @Size(max = 200)
    @Column(name = "password", nullable = false)
    private String password;
   
//    @OneToMany(mappedBy = "user_peminjaman", fetch = FetchType.LAZY)
//    private Set<PeminjamanModel> listPeminjaman = new HashSet<>();
//    
//    @OneToMany(mappedBy = "user_pengadaan", fetch = FetchType.LAZY)
//    private Set<PengadaanModel> listPengadaan = new HashSet<>();
//    
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_role", referencedColumnName = "id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private RoleModel user_role;
    
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public RoleModel getUser_role() {
//		return user_role;
//	}
//
//	public void setUser_role(RoleModel user_role) {
//		this.user_role = user_role;
//	}

//	public Set<PeminjamanModel> getListPeminjaman() {
//		return listPeminjaman;
//	}
//
//	public void setListPeminjaman(Set<PeminjamanModel> listPeminjaman) {
//		this.listPeminjaman = listPeminjaman;
//	}
//
//	public Set<PengadaanModel> getListPengadaan() {
//		return listPengadaan;
//	}
//
//	public void setListPengadaan(Set<PengadaanModel> listPengadaan) {
//		this.listPengadaan = listPengadaan;
//	}
	

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
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
	
	

//	@Override
//	public boolean equals(Object o) {
//	    if(o == null)
//	    {
//	        return false;
//	    }
//	    if (o == this)
//	    {
//	        return true;
//	    }
//	    if (getClass() != o.getClass())
//	    {
//	        return false;
//	    }
//	     
//	    UserModel user = (UserModel) o;
//	    return (this.getId() == user.getId());
//	}
//	
//	@Override
//	public int hashCode()
//	{
//	    final int PRIME = 31;
//	    int result = 1;
//	    result = PRIME * result + (int) getId();
//	    return result;
//	}  
	
	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String CreateNIP() {
		//Random Alphabet
		Random r = new Random();
        String random =  String.valueOf((char)(r.nextInt(26)+'A') + String.valueOf((char)(r.nextInt(26)+'A')));	
        //Formatting Year
		int year = Calendar.getInstance().get(Calendar.YEAR);
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
		String strDate= formatter.format(getTanggal_lahir());			
		return String.valueOf(year) + strDate + random ;
	}

}
