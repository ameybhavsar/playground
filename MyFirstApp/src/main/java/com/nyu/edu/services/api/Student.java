package com.nyu.edu.services.api;

/**
 * Created by Amey on 9/11/2016.
 */
public class Student {

    private String name;
    private String email;
    private String gender;

    public Student(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
