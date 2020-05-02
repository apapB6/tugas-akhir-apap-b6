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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "jenis_buku")
public class JenisModel implements Serializable {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max = 200)
    @Column(name = "jenis_buku", nullable = false)
    private String nama;
    
     @OneToMany(mappedBy = "buku_jenis", fetch = FetchType.LAZY)
     private Set<BukuModel> listBuku = new HashSet<>();
    
    /**
     * Getter&Setter
     */
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	 public Set<BukuModel> getListBuku() {
	 	return listBuku;
	 }

	 public void setListBuku(Set<BukuModel> listBuku) {
	 	this.listBuku = listBuku;
	 }

	@Override
	public boolean equals(Object o) {
	    if(o == null)
	    {
	        return false;
	    }
	    if (o == this)
	    {
	        return true;
	    }
	    if (getClass() != o.getClass())
	    {
	        return false;
	    }
	     
	    JenisModel jenis = (JenisModel) o;
	    return (this.getId() == jenis.getId());
	}
	
	@Override
	public int hashCode()
	{
	    final int PRIME = 31;
	    int result = 1;
	    result = PRIME * result + (int) getId();
	    return result;
	}
   
}
