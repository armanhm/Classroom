package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfStudentsActivity extends AppCompatActivity implements StudentAdapter.OnNoteListener {

    RecyclerView recyclerViewStudents;
    static ArrayList <ItemStudent> studentList;
    static String resultStudent = "";
    static ArrayList<String> arrayListStudents;
    static StudentAdapter studentAdapter;
    FloatingActionsMenu fam_main;
    ImageView addStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_students);

        studentList = new ArrayList<>();
        arrayListStudents = new ArrayList<>();

        addStudent = findViewById(R.id.imageView_add_student);



       String[] students = resultStudent.split(":");


        arrayListStudents.addAll(Arrays.asList(students).subList(1, students.length));


       recyclerViewStudents = findViewById(R.id.recyclerView_Students);



        studentList = new ArrayList<>();
        for (int i = 0; i < arrayListStudents.size()-1; i += 2) {
            ItemStudent itemStudent = new ItemStudent(arrayListStudents.get(i) , arrayListStudents.get(i+1));
            studentList.add(itemStudent);
        }


        studentAdapter  = new StudentAdapter(R.layout.item_teacher, studentList , this);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewStudents.setItemAnimator(new DefaultItemAnimator());
        recyclerViewStudents.setAdapter(studentAdapter);


        addStudent.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfStudentsActivity.this , AddStudentActivity.class);
            startActivity(intent);
        });

    }


    @Override
    public void onNoteClick(int position) {

    }
}
