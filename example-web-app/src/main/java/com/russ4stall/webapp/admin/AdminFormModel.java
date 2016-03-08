package com.russ4stall.webapp.admin;

import com.russ4stall.webapp.user.User;

/**
 * Created by russellf on 3/1/2016.
 */
public class AdminFormModel {
    private String name;
    private String email;
    private String username;
    private String role[];
    private int someNumber;

    public AdminFormModel() {
    }

    public User getUser() {
        return new User(this.name, this.email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) {
        this.someNumber = someNumber;
    }
}
