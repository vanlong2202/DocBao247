package com.example.a247.Model;

public class Comment {
    private int CommentID;
    private int PaperID;
    private int ProfileID;
    private String Text_comment;
    private String Time_comment;
    private String Date_comment;
    private String Description;
    private String Fullname;

    public Comment(int commentID, int paperID, int profileID, String text_comment, String time_comment, String date_comment, String description, String fullname) {
        CommentID = commentID;
        PaperID = paperID;
        ProfileID = profileID;
        Text_comment = text_comment;
        Time_comment = time_comment;
        Date_comment = date_comment;
        Description = description;
        Fullname = fullname;
    }

    public Comment() {

    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int commentID) {
        CommentID = commentID;
    }

    public int getPaperID() {
        return PaperID;
    }

    public void setPaperID(int paperID) {
        PaperID = paperID;
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        ProfileID = profileID;
    }

    public String getText_comment() {
        return Text_comment;
    }

    public void setText_comment(String text_comment) {
        Text_comment = text_comment;
    }

    public String getTime_comment() {
        return Time_comment;
    }

    public void setTime_comment(String time_comment) {
        Time_comment = time_comment;
    }

    public String getDate_comment() {
        return Date_comment;
    }

    public void setDate_comment(String date_comment) {
        Date_comment = date_comment;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "CommentID=" + CommentID +
                ", PaperID=" + PaperID +
                ", ProfileID=" + ProfileID +
                ", Text_comment='" + Text_comment + '\'' +
                ", Time_comment='" + Time_comment + '\'' +
                ", Date_comment='" + Date_comment + '\'' +
                ", Description='" + Description + '\'' +
                ", Fullname='" + Fullname + '\'' +
                '}';
    }
}
