package com.apap.finalprojectB6.model;

public class ValidateAddUser {
	private boolean status;
    private String description;
    private String table;

    public ValidateAddUser(boolean status, String description, String table) {
        this.status = status;
        this.description = description;
        this.table = table;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTable() {
        return this.table;
    }
}
