package com.example.testclassroom;

public class ItemInformation {
    private String homeworkName;
    private String grade;

    public ItemInformation(String homeworkName, String grade) {
        this.homeworkName = homeworkName;
        this.grade = grade;
    }

    public String getHomeworkName() {
        return homeworkName;
    }

    public void setHomeworkName(String homeworkName) {
        this.homeworkName = homeworkName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
