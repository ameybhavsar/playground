package com.nyu.edu.services.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Amey on 9/11/2016.
 */
public class Student {

    @JsonProperty("name")
    private String name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("gender")
    private String gender;

    @JsonProperty("picture")
    private Object picture;

    public Student() {
    }

    public Student(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public Student(String name, String email, String gender, Object picture) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.picture = picture;
    }

    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
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
