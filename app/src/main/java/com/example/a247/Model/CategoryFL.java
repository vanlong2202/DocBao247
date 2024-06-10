package com.example.a247.Model;

public class CategoryFL {
    private int CategoryFLID;
    private int CategoryID;
    private int ProfileID;
    private String CategoryName;
    private String Link;

    public CategoryFL() {
    }

    public CategoryFL(int categoryFLID, int categoryID, int profileID, String categoryName, String link) {
        CategoryFLID = categoryFLID;
        CategoryID = categoryID;
        ProfileID = profileID;
        CategoryName = categoryName;
        Link = link;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public int getCategoryFLID() {
        return CategoryFLID;
    }

    public void setCategoryFLID(int categoryFLID) {
        CategoryFLID = categoryFLID;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public int getProfileID() {
        return ProfileID;
    }

    public void setProfileID(int profileID) {
        ProfileID = profileID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryFL{" +
                "CategoryFLID=" + CategoryFLID +
                ", CategoryID=" + CategoryID +
                ", ProfileID=" + ProfileID +
                ", CategoryName='" + CategoryName + '\'' +
                '}';
    }
}
