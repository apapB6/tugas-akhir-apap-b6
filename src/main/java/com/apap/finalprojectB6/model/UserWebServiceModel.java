package com.apap.finalprojectB6.model;

import java.io.Serializable;

public class UserWebServiceModel implements Serializable {	

    private String username;

    private int id_role;
    
    public UserWebServiceModel(String username, int id_role){
    	this.username = username;
    	this.id_role = id_role;
    }

    /**
     * 
     * Getter&Setter
     */

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

}
