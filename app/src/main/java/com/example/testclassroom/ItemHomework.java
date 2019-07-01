package com.example.testclassroom;

public class ItemHomework {
    private String name;
    private String date;
    private String numberOfComments = "0";

    public ItemHomework(String name, String date,String numberOfComments) {
        this.name = name;
        this.date = date;
        this.numberOfComments = numberOfComments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}
