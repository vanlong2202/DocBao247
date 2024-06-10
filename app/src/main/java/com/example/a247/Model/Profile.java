package com.example.a247.Model;

public class Profile {
    private int ProfileID;
    private String Fullname;
    private String UserID;
    private String Phone;
    private String Address;
    private int Sex;
    private String Description;

    public Profile() {
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        ProfileID = profileID;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getSex() {
        return Sex;
    }

    public void setSex(int sex) {
        Sex = sex;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "ProfileID=" + ProfileID +
                ", Fullname='" + Fullname + '\'' +
                ", UserID='" + UserID + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Address='" + Address + '\'' +
                ", Sex=" + Sex +
                ", Description='" + Description + '\'' +
                '}';
    }
}
