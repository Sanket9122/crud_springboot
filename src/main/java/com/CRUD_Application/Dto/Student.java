package com.CRUD_Application.Dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//student model:
//id-primary key
//name , email , phone , course ,batch
//Entity is basically a table build in the database and the @Entity annotation is used to define a class as an entity.
@Entity
public class Student {
    //Id is the primary key of the table and the @Id annotation is used to define a field as a primary key.
    @Id
    //GeneratedValue is used to generate the primary key value automatically and the @GeneratedValue annotation is used to define a field as a generated value.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int phone;
    private String course;
    private String batch;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getPhone(){
        return phone;
    }
    public void setPhone(int Phone){
        this.phone = Phone;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public String getBatch(){
        return batch;
    }
    public void setBatch(String batch){
        this.batch = batch;
    }
}
