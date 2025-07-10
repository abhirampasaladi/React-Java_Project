package org.project.ew_backend.model;

public class BankDB {
    private String id;
    private String username;
    private String password;
    private String email;
    private String phone;

    BankDB(String id, String username, String password, String email, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
}
