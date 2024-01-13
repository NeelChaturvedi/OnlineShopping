package com.example.onlineshopping.models;

public class UserDataModel {
    private int id;
    private String name;
    private String contactNo;
    private String email;
    private String address;
    private String dateOfBirth;

    public UserDataModel(int id, String name, String contactNo, String email, String address, String dateOfBirth) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.email = email;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
