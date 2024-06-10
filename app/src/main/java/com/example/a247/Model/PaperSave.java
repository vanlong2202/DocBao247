package com.example.a247.Model;

public class PaperSave {
    private int PaperSaveID;
    private int PaperID;
    private int ProfileID;
    private String title;
    private String time;
    private String date;

    public PaperSave() {
    }

    public PaperSave(int paperSaveID, int paperID, int profileID, String title, String time, String date) {
        PaperSaveID = paperSaveID;
        PaperID = paperID;
        ProfileID = profileID;
        this.title = title;
        this.time = time;
        this.date = date;
    }

    public int getPaperSaveID() {
        return PaperSaveID;
    }

    public void setPaperSaveID(int paperSaveID) {
        PaperSaveID = paperSaveID;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "PaperSave{" +
                "PaperSaveID=" + PaperSaveID +
                ", PaperID=" + PaperID +
                ", ProfileID=" + ProfileID +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
