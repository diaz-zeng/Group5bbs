package com.soft863.group5.bbs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class PointRecord implements Serializable {

    private Integer    id;
    private Integer    integral;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date       date;
    private String     source;
    private User    user;

    public PointRecord() {
    }

    public PointRecord(Integer integral, Date date, String source, User user) {
        this.integral = integral;
        this.date = date;
        this.source = source;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PointRecord{" +
                "id=" + id +
                ", integral=" + integral +
                ", date=" + date +
                ", source='" + source + '\'' +
                '}';
    }
}
