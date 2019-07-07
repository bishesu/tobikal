package com.example.androidassignment.Model;

public class FeedbackModel {
    private String fullname;
    private String description;
    private String email;
    private String contact;

    public FeedbackModel(String fullname, String description, String email, String contact) {
        this.fullname = fullname;
        this.description = description;
        this.email = email;
        this.contact = contact;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
