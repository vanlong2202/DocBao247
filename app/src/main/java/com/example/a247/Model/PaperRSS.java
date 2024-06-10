package com.example.a247.Model;

public class PaperRSS {
    private String title;
    private String description;
    private String time;
    private String date;
    private String link;
    private String link_img;

    public PaperRSS(String title, String description, String time, String date, String link, String link_img) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
        this.link = link;
        this.link_img = link_img;
    }

    public PaperRSS() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }
}
