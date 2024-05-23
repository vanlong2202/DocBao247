package com.example.a247.Model;

public class Paper {
    private int PaperID;
    private String Title_paper;
    private String Text1_paper;
    private String Text2_paper;
    private String Img_paper;
    private String Time_paper;
    private String Date_paper;
    private int CategoroyID;
    private String Description;
    private String Category_name;

    public Paper(){

    }

    public Paper(int paperID, String title_paper, String text1_paper, String text2_paper, String img_paper, String time_paper, String date_paper, int categoroyID, String description, String category_name) {
        PaperID = paperID;
        Title_paper = title_paper;
        Text1_paper = text1_paper;
        Text2_paper = text2_paper;
        Img_paper = img_paper;
        Time_paper = time_paper;
        Date_paper = date_paper;
        CategoroyID = categoroyID;
        Description = description;
        Category_name = category_name;
    }

    public int getPaperID() {
        return PaperID;
    }

    public void setPaperID(int paperID) {
        PaperID = paperID;
    }

    public String getTitle_paper() {
        return Title_paper;
    }

    public void setTitle_paper(String title_paper) {
        Title_paper = title_paper;
    }

    public String getText1_paper() {
        return Text1_paper;
    }

    public void setText1_paper(String text1_paper) {
        Text1_paper = text1_paper;
    }

    public String getText2_paper() {
        return Text2_paper;
    }

    public void setText2_paper(String text2_paper) {
        Text2_paper = text2_paper;
    }

    public String getImg_paper() {
        return Img_paper;
    }

    public void setImg_paper(String img_paper) {
        Img_paper = img_paper;
    }

    public String getTime_paper() {
        return Time_paper;
    }

    public void setTime_paper(String time_paper) {
        Time_paper = time_paper;
    }

    public String getDate_paper() {
        return Date_paper;
    }

    public void setDate_paper(String date_paper) {
        Date_paper = date_paper;
    }

    public int getCategoroyID() {
        return CategoroyID;
    }

    public void setCategoroyID(int categoroyID) {
        CategoroyID = categoroyID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCategory_name() {
        return Category_name;
    }

    public void setCategory_name(String category_name) {
        Category_name = category_name;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "PaperID=" + PaperID +
                ", Title_paper='" + Title_paper + '\'' +
                ", Text1_paper='" + Text1_paper + '\'' +
                ", Text2_paper='" + Text2_paper + '\'' +
                ", Img_paper='" + Img_paper + '\'' +
                ", Time_paper='" + Time_paper + '\'' +
                ", Date_paper='" + Date_paper + '\'' +
                ", CategoroyID=" + CategoroyID +
                ", Description='" + Description + '\'' +
                ", Category_name='" + Category_name + '\'' +
                '}';
    }
}
