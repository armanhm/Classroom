package com.example.testclassroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfTeachersActivity extends AppCompatActivity implements TeacherAdapter.OnNoteListener {
    RecyclerView recyclerViewTeacher;
    FloatingActionsMenu fam_main;
    static ArrayList<ItemTeacher> teacherList;
    static String resultTeacher = "";
    static ArrayList<String> arrayListTeachers;
    static TeacherAdapter teacherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        teacherList = new ArrayList<>();
        arrayListTeachers = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_teachers);
        resultTeacher = ListOfHomeworkActivity.listOfTeachers;

        Log.e("resultTeacher" , resultTeacher);

        String[] teachers = resultTeacher.split(":");

        arrayListTeachers.addAll(Arrays.asList(teachers));

        recyclerViewTeacher = findViewById(R.id.recyclerView_teachers);

        teacherList = new ArrayList<>();
        for (int i = 2; i < arrayListTeachers.size() - 1; i += 2) {
            ItemTeacher itemTeacher = new ItemTeacher(arrayListTeachers.get(i), arrayListTeachers.get(i + 1));
            teacherList.add(itemTeacher);
        }

        teacherAdapter = new TeacherAdapter(R.layout.item_teacher, teacherList, this);
        recyclerViewTeacher.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTeacher.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTeacher.setAdapter(teacherAdapter);


    }

    @Override
    public void onNoteClick(int position) {

    }
}
