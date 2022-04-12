package com.example.android_instagramclone_java.model;

public class Post {
    String caption = "";
    String image = "";
    public Post( String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
