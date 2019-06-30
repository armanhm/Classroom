package com.example.testclassroom;

public class ItemHomework {
    private String name;
    private String date;
    private String time;
    private String numberOfComments = "0";

    public ItemHomework(String name, String date, String time, String numberOfComments) {
        this.name = name;
        this.date = date;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(String numberOfComments) {
        this.numberOfComments = numberOfComments;
    }
}
