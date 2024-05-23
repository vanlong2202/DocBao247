package com.example.a247.Model;

public class CategoryFL {
    private int CategoryFLID;
    private int CategoryID;
    private int ProfileID;
    private String Description;

    public CategoryFL(int categoryFLID, int categoryID, int profileID, String description) {
        CategoryFLID = categoryFLID;
        CategoryID = categoryID;
        ProfileID = profileID;
        Description = description;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "CategoryFL{" +
                "CategoryFLID=" + CategoryFLID +
                ", CategoryID=" + CategoryID +
                ", ProfileID=" + ProfileID +
                ", Description='" + Description + '\'' +
                '}';
    }
}
