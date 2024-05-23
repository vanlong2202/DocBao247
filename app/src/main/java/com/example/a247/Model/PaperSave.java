package com.example.a247.Model;

public class PaperSave {
    private int PaperSaveID;
    private int PaperID;
    private int ProfileID;
    private String Description;

    public PaperSave(int paperSaveID, int paperID, int profileID, String description) {
        PaperSaveID = paperSaveID;
        PaperID = paperID;
        ProfileID = profileID;
        Description = description;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "PaperSave{" +
                "PaperSaveID=" + PaperSaveID +
                ", PaperID=" + PaperID +
                ", ProfileID=" + ProfileID +
                ", Description='" + Description + '\'' +
                '}';
    }
}
