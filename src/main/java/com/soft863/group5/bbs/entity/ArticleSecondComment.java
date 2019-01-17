package com.soft863.group5.bbs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Diaz
 * @since 2019/1/15 19:49
 */
public class ArticleSecondComment implements Serializable {
    private Long id;
    private User user;
    private ArticleFirstComment firstComment;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;

    public ArticleSecondComment() {
    }

    public ArticleSecondComment(User user, ArticleFirstComment firstComment, String content, Date date) {
        this.user = user;
        this.firstComment = firstComment;
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArticleFirstComment getFirstComment() {
        return firstComment;
    }

    public void setFirstComment(ArticleFirstComment firstComment) {
        this.firstComment = firstComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
