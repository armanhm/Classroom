package com.example.testclassroom;


import java.io.Serializable;
import java.util.*;

class Class implements Serializable {
    private String name;
    private String description;
    private String number;
    private String code;
    private Person teacher;
    private ArrayList<Person> TAs = new ArrayList<>();
    private ArrayList<Person> students = new ArrayList<>();
    private ArrayList <ItemHomework> itemHomework = new ArrayList<>();


    public Class(Person p,String name, String description, String number) {
        teacher = p ;
        this.name = name;
        this.description = description;
        this.number = number;
    }

    public ArrayList<ItemHomework> getItemHomework() {
        return itemHomework;
    }

    public void setItemHomework(ArrayList<ItemHomework> itemHomework) {
        this.itemHomework = itemHomework;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Person> getStudents() {
        return students;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}