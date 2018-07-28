package com.example.farhan.newsfeed;

/**
 * Created by Farhan on 12/12/2017.
 */

public class News {

    private String title;
    private String author;
    private String url;
    private String date;

    public News(String title, String author, String url, String date) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
