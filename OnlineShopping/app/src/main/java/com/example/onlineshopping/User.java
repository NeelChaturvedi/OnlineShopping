package com.example.onlineshopping;

public class User {

    private String name;
    private String contact;
    private String email;
    private String address;
    private String dob;

    public User(String name, String contact, String email, String address, String dob) {
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.address = address;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }
}

