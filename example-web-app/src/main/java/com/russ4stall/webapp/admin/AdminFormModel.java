package com.russ4stall.webapp.admin;

import com.russ4stall.webapp.user.User;

/**
 * Created by russellf on 3/1/2016.
 */
public class AdminFormModel {
    private User user;
    private String username;
    private String role;
    private int someNumber;

    public AdminFormModel() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSomeNumber() {
        return someNumber;
    }

    public void setSomeNumber(int someNumber) {
        this.someNumber = someNumber;
    }
}
