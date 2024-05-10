package com.example.a247;

public class ListPaper {
    private int img_paper;
    private String tv_title;
    private String tv_text;
    private String tv_time;

    public ListPaper(int img_paper, String tv_title, String tv_text, String tv_time) {
        this.img_paper = img_paper;
        this.tv_title = tv_title;
        this.tv_text = tv_text;
        this.tv_time = tv_time;
    }

    public int getImg_paper() {
        return img_paper;
    }

    public void setImg_paper(int img_paper) {
        this.img_paper = img_paper;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_text() {
        return tv_text;
    }

    public void setTv_text(String tv_text) {
        this.tv_text = tv_text;
    }

    public String getTv_time() {
        return tv_time;
    }

    public void setTv_time(String tv_time) {
        this.tv_time = tv_time;
    }
}
