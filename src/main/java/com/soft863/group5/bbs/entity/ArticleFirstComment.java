package com.soft863.group5.bbs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Diaz
 * @since 2019/1/15 19:49
 */
public class ArticleFirstComment implements Serializable {
    private Long id;
    private User user;
    private Article article;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private Set<ArticleSecondComment> secondComments = new HashSet<>();

    public ArticleFirstComment() {
    }

    public ArticleFirstComment(User user, Article article, String content, Date date, Set<ArticleSecondComment> secondComments) {
        this.user = user;
        this.article = article;
        this.content = content;
        this.date = date;
        this.secondComments = secondComments;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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

    public Set<ArticleSecondComment> getSecondComments() {
        return secondComments;
    }

    public void setSecondComments(Set<ArticleSecondComment> secondComments) {
        this.secondComments = secondComments;
    }
}
