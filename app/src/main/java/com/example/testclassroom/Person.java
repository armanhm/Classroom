package com.example.testclassroom;

import java.util.ArrayList;

public class Person {
    private String username ;
    private String password ;
    private ArrayList <Class> classes = new ArrayList<>();
    private ArrayList <ItemClass> itemClasses = new ArrayList<>();


    public ArrayList<ItemClass> getItemClasses() {
        return itemClasses;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }
}
