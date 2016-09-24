package com.nyu.edu.services.api;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Amey on 9/11/2016.
 */
@DynamoDBTable(tableName = "student")
public class Student<T> {

    @JsonProperty("id")
    private Integer id;

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

    public Student(Integer id, String name, String email, String gender, Object picture) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.picture = picture;
    }

    //Partition key
    @DynamoDBHashKey(attributeName = "Id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName = "Gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @DynamoDBAttribute(attributeName = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @DynamoDBAttribute(attributeName = "Picture")
    public Object getPicture() {
        return picture;
    }

    public void setPicture(Object picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", picture=" + picture +
                '}';
    }
}
