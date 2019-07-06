package com.example.testclassroom;

import android.content.Intent;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfHomeworkActivity extends AppCompatActivity implements HomeworkAdapter.OnNoteListener {
    RecyclerView recyclerViewHomework;
    static ArrayList<String> arrayListHomework;
    static String listOfHomework = "";
    static String listOfTeachers = "";
    static String listOfStudents = "";
    static String classCode = "";
    static String userType = "";
    static String homeworkCode = "";
    ArrayList<ItemHomework> homeworkList;
    FloatingActionButton fab_homework, fab_topic, fab_exam;
    FloatingActionsMenu fam_main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ItemHomework.homeworkCodes = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_homework);


        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fab_homework = findViewById(R.id.fab_create_homework);
        fab_topic = findViewById(R.id.fab_add_topic);
        fab_exam = findViewById(R.id.fab_create_exam);
        fam_main = findViewById(R.id.fab_homework_main);


        arrayListHomework = new ArrayList<>();

        //refresh function

        String[] s = listOfHomework.split(":");
        arrayListHomework.addAll(Arrays.asList(s));

        recyclerViewHomework = findViewById(R.id.recyclerViewHomework);

        homeworkList = new ArrayList<>();

        Log.e("classCode", classCode);


        for (int i = 2; i < arrayListHomework.size() - 2; i += 4) {
            ItemHomework itemHomework = new ItemHomework(arrayListHomework.get(i), arrayListHomework.get(i + 1), arrayListHomework.get(i + 2));
            ItemHomework.homeworkCodes.add(arrayListHomework.get(i + 3));
            homeworkList.add(itemHomework);
        }

        ListOfClassActivity.c.setItemHomework(homeworkList);
        HomeworkAdapter homeworkAdapter = new HomeworkAdapter(R.layout.item_homework, ListOfClassActivity.c.getItemHomework(), this);
        recyclerViewHomework.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHomework.setItemAnimator(new DefaultItemAnimator());
        recyclerViewHomework.setAdapter(homeworkAdapter);


        if (ListOfHomeworkActivity.userType.equals("student")) {
            fam_main.setVisibility(View.INVISIBLE);
        }
        fab_homework.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfHomeworkActivity.this, CreateHomeworkActivity.class);
            startActivity(intent);
        });

        fab_topic.setOnClickListener(v -> {
            new TransferMessage().execute("topics:" + classCode);
            Intent intent = new Intent(ListOfHomeworkActivity.this, AddTopicActivity.class);
            startActivity(intent);
        });

        fab_exam.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfHomeworkActivity.this, CreateExamActivity.class);
            startActivity(intent);
        });
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        //Fragment fragment;
        switch (item.getItemId()) {
            case R.id.action_students_bottom_navigation:
                Toast.makeText(ListOfHomeworkActivity.this, "Students", Toast.LENGTH_SHORT).show();
                new TransferMessage().execute("studentList:" + classCode);
                Intent intent1 = new Intent(ListOfHomeworkActivity.this, ListOfStudentsActivity.class);
                startActivity(intent1);
                return true;
            case R.id.action_classwork_bottom_navigation:
                Intent intent2 = new Intent(ListOfHomeworkActivity.this, ListOfHomeworkActivity.class);
                new TransferMessage().execute("homeworkList:" + classCode);
                startActivity(intent2);
                Toast.makeText(ListOfHomeworkActivity.this, "classwork", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_teachers_bottom_Navigation:
                Toast.makeText(ListOfHomeworkActivity.this, "teacherList", Toast.LENGTH_SHORT).show();
                new TransferMessage().execute("teacherList:" + classCode);
                Intent intent3 = new Intent(ListOfHomeworkActivity.this, ListOfTeachersActivity.class);
                startActivity(intent3);
                return true;
        }
        return false;
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_refresh_homework, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh_homework) {
            new TransferMessage().execute("homeworkList:" + classCode + ":" + WelcomeActivity.username);
            //   CreateHomeworkActivity.refreshHomework(ListOfHomeworkActivity.classCode);
            Intent intent = new Intent(ListOfHomeworkActivity.this, ListOfHomeworkActivity.class);
            startActivity(intent);
        } else if (id == R.id.action_classes) {
            CreateClassActivity.refreshList();
            Intent intent = new Intent(ListOfHomeworkActivity.this, ListOfClassActivity.class);
            startActivity(intent);

        } else if (id == R.id.action_notifications) {
            Intent intent = new Intent(ListOfHomeworkActivity.this, NotificationActivity.class);
            startActivity(intent);

        } else if (id == R.id.action_about_us) {
            Intent intent = new Intent(ListOfHomeworkActivity.this, AboutUsActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onNoteClick(int position) {
        if (userType.equals("teacher")) {
            Log.e("userType", ListOfHomeworkActivity.userType);
            Intent intent = new Intent(ListOfHomeworkActivity.this, ProfileHomeworkTeacherActivity.class);
            startActivity(intent);
        } else {
            ItemHomework itemHomework = homeworkList.get(position);
            homeworkCode = ItemHomework.homeworkCodes.get(position);
            Intent intent = new Intent(ListOfHomeworkActivity.this, ProfileHomeworkStudentActivity.class);
            intent.putExtra("homeworkName", itemHomework.getName());
            intent.putExtra("homeworkCode", ItemHomework.homeworkCodes.get(position));
            startActivity(intent);
            //new TransferMessage().execute("homeworkProfile:" + itemHomework.getName()) ;
        }

    }
}
