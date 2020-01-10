package com.si.twitterkessi.model;

public class ModelUser {
    String email;
    String password;
    String username;
    String image;

    public ModelUser(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public ModelUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public ModelUser(String email, String password, String username, String image) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.image = image;
    }


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getImageName() {
        return image;
    }
}
