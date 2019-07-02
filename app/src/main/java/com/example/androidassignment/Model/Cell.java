package com.example.androidassignment.Model;

public class Cell {

    private String titleimg;
    private Integer img;

    public Cell(String titleimg, Integer img) {
        this.titleimg = titleimg;
        this.img = img;
    }

    public String getTitleimg() {
        return titleimg;
    }

    public void setTitleimg(String titleimg) {
        this.titleimg = titleimg;
    }

    public Integer getImg() {
        return img;
    }

    public void setImg(Integer img) {
        this.img = img;
    }
}
