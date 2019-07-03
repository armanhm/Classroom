package com.example.testclassroom;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemClass {
    private String name;
    private String numberOfStudent;
    static ArrayList<String> classCodes;

    public ItemClass(String name, String numberOfStudent) {
        this.name = name;
        this.numberOfStudent = numberOfStudent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumberOfStudent(String numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public String getNumberOfStudent() {
        return numberOfStudent;
    }
}
