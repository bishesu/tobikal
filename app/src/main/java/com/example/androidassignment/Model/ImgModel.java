package com.example.androidassignment.Model;

public class ImgModel {
    private String imagename;
    private String description;
    private String userid;

    public ImgModel(String imagename, String description, String userid) {
        this.imagename = imagename;
        this.description = description;
        this.userid = userid;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
