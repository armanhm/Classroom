package com.example.testclassroom;

public class ItemTeacher {
    private String username ;
    private String image ;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ItemTeacher(String username, String image) {
        this.username = username;
        this.image = image;
    }
}
