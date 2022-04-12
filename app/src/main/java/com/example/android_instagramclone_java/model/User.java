package com.example.android_instagramclone_java.model;

public class User {
    String fullname;
    String email;

    public User(String fullname, String email) {
        this.fullname = fullname;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
