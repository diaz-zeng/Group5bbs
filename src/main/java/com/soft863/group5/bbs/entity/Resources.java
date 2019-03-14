package com.soft863.group5.bbs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * author zhaosl
 * date 2019/1/15 17:19
 *
 * @version 1.0
 */
public class Resources implements Serializable {
    private Long id;
    private String name;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private Integer times;
    private String describe;
    private String filepath;
    private String truename;
    private Double filesize;
    private Integer check;
    private User user;
    private String keywords;
    private List<ResourceComments> resourceComments;

    public Resources() {
    }

    public Resources(String name, Integer score, Date date, Integer times, String describe, String filepath, String truename, Double filesize, Integer check, User user, String keywords, List<ResourceComments> resourceComments) {
        this.name = name;
        this.score = score;
        this.date = date;
        this.times = times;
        this.describe = describe;
        this.filepath = filepath;
        this.truename = truename;
        this.filesize = filesize;
        this.check = check;
        this.user = user;
        this.keywords = keywords;
        this.resourceComments = resourceComments;
    }

    public String getTruename() { return truename; }

    public void setTruename(String truename) { this.truename = truename; }

    public List<ResourceComments> getResourceComments() {
        return resourceComments;
    }

    public void setResourceComments(List<ResourceComments> resourceComments) { this.resourceComments = resourceComments; }

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

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public Double getFilesize() {
        return filesize;
    }

    public void setFilesize(Double filesize) {
        this.filesize = filesize;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", date=" + date +
                ", times=" + times +
                ", describe='" + describe + '\'' +
                ", filepath='" + filepath + '\'' +
                ", truename='" + truename + '\'' +
                ", filesize=" + filesize +
                ", check=" + check +
                ", user=" + user +
                ", keywords='" + keywords + '\'' +
                ", resourceComments=" + resourceComments +
                '}';
    }
}

