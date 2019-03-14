package com.soft863.group5.bbs.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Diaz
 * @since 2019/1/15 19:40
 */
public class Article implements Serializable {
    private Long id;
    private String group;
    private String title;
    private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
    private Integer top;
    private Integer pass;
    private User user;
    private Set<ArticleFirstComment> firstComments = new HashSet<>();

    public Article() {
    }

    public Article(String group, String title, String content, Date date, Integer top, Integer pass, User user, Set<ArticleFirstComment> firstComments) {
        this.group = group;
        this.title = title;
        this.content = content;
        this.date = date;
        this.top = top;
        this.pass = pass;
        this.user = user;
        this.firstComments = firstComments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ArticleFirstComment> getFirstComments() {
        return firstComments;
    }

    public void setFirstComments(Set<ArticleFirstComment> firstComments) {
        this.firstComments = firstComments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) &&
                Objects.equals(group, article.group) &&
                Objects.equals(title, article.title) &&
                Objects.equals(content, article.content) &&
                Objects.equals(date, article.date) &&
                Objects.equals(top, article.top) &&
                Objects.equals(pass, article.pass) &&
                Objects.equals(user, article.user) &&
                Objects.equals(firstComments, article.firstComments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, group, title, content, date, top, pass, user, firstComments);
    }
}
