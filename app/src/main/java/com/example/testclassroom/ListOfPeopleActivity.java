package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfPeopleActivity extends AppCompatActivity implements PeopleAdapter.OnNoteListener {

    RecyclerView recyclerViewStudents , recyclerViewTeachers;
    static ArrayList <ItemPeople> studentList;
    static ArrayList<ItemPeople> teacherList;
    static String resultTeacher = "";
    static String resultStudent = "";
    static ArrayList<String> arrayListStudents;
    static ArrayList<String> arrayListTeachers;
    static PeopleAdapter studentAdapter , teacherAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        studentList = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_people);


       String[] teachers = resultTeacher.split(":");
       String[] students = resultStudent.split(":");


        arrayListStudents.addAll(Arrays.asList(students).subList(1, students.length));
        arrayListTeachers.addAll(Arrays.asList(teachers).subList(1, teachers.length));

       recyclerViewStudents = findViewById(R.id.recyclerView_Students);
       recyclerViewTeachers = findViewById(R.id.recyclerView_teachers);


        studentList = new ArrayList<>();
        teacherList = new ArrayList<>();
        for (int i = 0; i < arrayListStudents.size()-1; i += 2) {
            ItemPeople itemPeople = new ItemPeople(arrayListStudents.get(i) , arrayListStudents.get(i+1));
            studentList.add(itemPeople);
        }
        for (int i = 0; i < arrayListTeachers.size()-1; i += 2) {
            ItemPeople itemPeople = new ItemPeople(arrayListTeachers.get(i) , arrayListStudents.get(i+1));
            teacherList.add(itemPeople);
        }

        teacherAdapter = new PeopleAdapter(R.layout.item_people , teacherList , this);
        recyclerViewTeachers.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTeachers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTeachers.setAdapter(teacherAdapter);

        studentAdapter  = new PeopleAdapter(R.layout.item_people , studentList , this);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStudents.setItemAnimator(new DefaultItemAnimator());
        recyclerViewStudents.setAdapter(studentAdapter);



    }


    @Override
    public void onNoteClick(int position) {

    }
}
