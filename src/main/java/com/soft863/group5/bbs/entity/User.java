package com.soft863.group5.bbs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private Long id;
    private String name;
    private String photo;
    private String password;
    private String phone;
    private String email;
    private Integer scores;
    private List<Resources> resources = new ArrayList<>();
    private List<PointRecord> records = new ArrayList<>();


    public User() {
    }

    public User(String name, String photo, String password, String phone, String email, Integer scores, List<Resources> resources, List<PointRecord> records) {
        this.name = name;
        this.photo = photo;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.scores = scores;
        this.resources = resources;
        this.records = records;
    }

    public User(Long id, String name, String password, String phone, String email, Integer scores) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.scores = scores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Resources> getResources() {
        return resources;
    }

    public void setResources(List<Resources> resources) {
        this.resources = resources;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public List<PointRecord> getRecords() {
        return records;
    }

    public void setRecords(List<PointRecord> records) {
        this.records = records;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", scores=" + scores +
                ", resources=" + resources +
                '}';
    }
}
