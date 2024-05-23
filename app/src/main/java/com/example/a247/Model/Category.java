package com.example.a247.Model;

public class Category {
    private int CategoryID;
    private String Category_name;
    private String Description;

    public Category(int categoryID, String category_name, String description) {
        CategoryID = categoryID;
        Category_name = category_name;
        Description = description;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryID=" + CategoryID +
                ", Category_name='" + Category_name + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
