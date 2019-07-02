package com.example.androidassignment.Model;

public class UserModel {

   private String firstname;
    private String   lastname;
    private String  email;
    private String  dateofbirth;
    private String  contact;
    private String  username;
    private String   password;
    private String   description;
    private String   usertype;
    private String   profilepicture;

    public UserModel(String firstname, String lastname, String email, String dateofbirth, String contact, String username, String password, String description, String usertype, String profilepicture) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dateofbirth = dateofbirth;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.description = description;
        this.usertype = usertype;
        this.profilepicture = profilepicture;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }
}
