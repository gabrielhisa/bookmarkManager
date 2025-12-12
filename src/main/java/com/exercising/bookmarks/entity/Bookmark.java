package com.exercising.bookmarks.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bookmark {

    // Not using @Column annotation here as the database names are the same

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private String category;
    @Column(name = "timestamp")
    private Date timeStamp;

    public Bookmark(){

    }
    public Bookmark(Long id, String title, String url, String category, Date timeStamp) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.category = category;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
