package com.example.a247;

public class CommetPaper {
    private String tv_username;
    private String tv_timeComment;
    private String tv_textComment;

    public CommetPaper(String tv_username, String tv_timeComment, String tv_textComment) {
        this.tv_username = tv_username;
        this.tv_timeComment = tv_timeComment;
        this.tv_textComment = tv_textComment;
    }

    public String getTv_username() {
        return tv_username;
    }

    public void setTv_username(String tv_username) {
        this.tv_username = tv_username;
    }

    public String getTv_timeComment() {
        return tv_timeComment;
    }

    public void setTv_timeComment(String tv_timeComment) {
        this.tv_timeComment = tv_timeComment;
    }

    public String getTv_textComment() {
        return tv_textComment;
    }

    public void setTv_textComment(String tv_textComment) {
        this.tv_textComment = tv_textComment;
    }
}
