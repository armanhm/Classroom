package com.example.testclassroom;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfileHomeworkTeacherActivity extends AppCompatActivity  implements StudentWorkAdapter.OnNoteListener{

    RecyclerView recyclerView ;
    static ArrayList<String> arrayListStudentWork;
    static String listString = "";
    static String classCode = "";
    static Class c;
    ArrayList<ItemStudentWork> studentWorks;
    static StudentWorkAdapter studentWorkAdapter;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        bottomNavigationView = findViewById(R.id.bottom_navigation_homework_teacher);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        arrayListStudentWork = new ArrayList<>() ;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_homework_teacher);
        recyclerView = findViewById(R.id.recyclerView_homework_teacher) ;



        //listString is result of server
        String[] s = listString.split(":");
        arrayListStudentWork.addAll(Arrays.asList(s).subList(2, s.length));

        recyclerView = findViewById(R.id.recyclerViewClassNames);

        studentWorks = new ArrayList<>() ;
        for (int i = 0; i < studentWorks.size()-1; i += 3) {
            ItemStudentWork itemClass = new ItemStudentWork(arrayListStudentWork.get(i) , arrayListStudentWork.get(i+1),arrayListStudentWork.get(i+2));
            studentWorks.add(itemClass);
        }



        studentWorkAdapter = new StudentWorkAdapter(R.layout.item_student_works,studentWorks,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(studentWorkAdapter);



    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        //Fragment fragment;
        switch (item.getItemId()) {
            case R.id.action_students_bottom_navigation:
                Toast.makeText(ProfileHomeworkTeacherActivity.this, "Studentworks", Toast.LENGTH_SHORT).show();
                new TransferMessage().execute("studentWork:" + ListOfHomeworkActivity.homeworkCode); //homework Code
                Intent intent1 = new Intent(ProfileHomeworkTeacherActivity.this, ProfileHomeworkTeacherActivity.class);
                startActivity(intent1);
                return true;
            case R.id.action_classwork_bottom_navigation:
                Intent intent2 = new Intent(ProfileHomeworkTeacherActivity.this , ListOfInstructionsActivity.class);
                new TransferMessage().execute("instructions:" + ListOfHomeworkActivity.homeworkCode);
                startActivity(intent2);
                Toast.makeText(ProfileHomeworkTeacherActivity.this, "Instructions", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    };



    @Override
    public void onNoteClick(int position) {

    }
}
