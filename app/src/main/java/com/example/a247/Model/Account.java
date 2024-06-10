package com.example.a247.Model;

public class Account {
    private String UserID;
    private String Password;
    private String Description;

    public Account() {
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Account{" +
                "UserID='" + UserID + '\'' +
                ", Password='" + Password + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
