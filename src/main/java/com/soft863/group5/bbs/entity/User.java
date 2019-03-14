package com.soft863.group5.bbs.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
    private Long id;
    private String truename;
    private String name;
    private Date   birth;
    private String sex;
    private String photo;
    private String password;
    private String phone;
    private String email;
    private Integer scores;
    private Integer attention;

    private List<Resources> resources = new ArrayList<>();
    private List<PointRecord> records = new ArrayList<>();
    private List<Favorite> favorites = new ArrayList<>();


    public User() {
    }

    public User(Long id, String truename, String name, Date birth, String sex, String photo, String password, String phone, String email, Integer scores, Integer attention, List<Resources> resources, List<PointRecord> records) {
        this.id = id;
        this.truename = truename;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.photo = photo;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.scores = scores;
        this.attention = attention;
        this.resources = resources;
        this.records = records;
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

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
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
                ", truename='" + truename + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", scores=" + scores +
                ", attention=" + attention +
                '}';
    }
}
