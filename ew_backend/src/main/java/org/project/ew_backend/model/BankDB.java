package org.project.ew_backend.model;

// Entity class
public class BankDB {
    private String username;
    private String password;
    private String email;
    private String phone;

    BankDB(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }


}
