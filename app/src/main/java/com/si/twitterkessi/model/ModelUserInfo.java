package com.si.twitterkessi.model;

public class ModelUserInfo {
    String email;
    String _id;
    String username;
    String image;

    public ModelUserInfo(String email, String _id, String username, String image) {
        this.email = email;
        this._id = _id;
        this.username = username;
        this.image = image;
    }

    public String getEmail() {
        return email;
    }

    public String get_id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public String getImage() {
        return image;
    }
}
