package com.russ4stall.webapp.admin;

import com.russ4stall.webapp.user.User;

import java.util.Arrays;

/**
 * Created by russellf on 3/1/2016.
 */
public class AdminFormModel {
    private String name;
    private String email;
    private String username;
    private String role[];
    private int someNumber;

    private String resultType;

    public AdminFormModel() {
    }

    public User getUser() {
        return new User(this.name, this.email);
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        //this.resultType = ResultType.valueOf(resultType);
        this.resultType = resultType;
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

    @Override
    public String toString() {
        return "AdminFormModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", role=" + Arrays.toString(role) +
                ", someNumber=" + someNumber +
                ", resultType=" + resultType +
                '}';
    }
}
