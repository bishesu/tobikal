package com.example.androidassignment.Model;

public class Cell {

    private String titleimg;
    private String imagename;
    private String description;

    public Cell(String titleimg, String imagename, String description) {
        this.titleimg = titleimg;
        this.imagename = imagename;
        this.description = description;
    }

    public String getTitleimg() {
        return titleimg;
    }

    public void setTitleimg(String titleimg) {
        this.titleimg = titleimg;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
