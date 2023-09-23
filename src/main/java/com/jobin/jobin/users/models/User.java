package com.jobin.jobin.users.models;


import org.springframework.data.relational.core.mapping.Table;

@Table
public class User {
    private int id;
    private String email;
    private String password;
    private int userTypeId;
    private int userId;

    public User(int id, String email, String password, int userTypeId, int userId) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userTypeId = userTypeId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}