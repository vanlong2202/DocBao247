package com.example.a247;

public class PaperRss {
    private String title;
    private String description;
    private String time;
    private String date;
    private String link;
    private String img_link;

    public PaperRss(String title, String description, String time, String date, String link, String img_link) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.date = date;
        this.link = link;
        this.img_link = img_link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImg_link() {
        return img_link;
    }

    public void setImg_link(String img_link) {
        this.img_link = img_link;
    }
}
