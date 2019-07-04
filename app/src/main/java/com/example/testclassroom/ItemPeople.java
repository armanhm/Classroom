package com.example.testclassroom;

import android.net.Uri;

import java.net.URI;

public class ItemPeople {
    private String username ;
    private Uri image ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    public ItemPeople(String username, Uri image) {


        this.username = username;
        this.image = image;
    }


}
