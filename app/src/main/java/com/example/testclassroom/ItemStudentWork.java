package com.example.testclassroom;

public class ItemStudentWork {
    private String name ;
    private String imageProfile ;
    private String point ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public ItemStudentWork(String name, String imageProfile, String point) {
        this.name = name;
        this.imageProfile = imageProfile;
        this.point = point;
    }
}
