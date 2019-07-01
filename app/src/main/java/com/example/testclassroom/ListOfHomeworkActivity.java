package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfHomeworkActivity extends AppCompatActivity implements HomeworkAdapter.OnNoteListener {
    RecyclerView recyclerViewHomework;
    static ArrayList<String> arrayListHomework;
    static String listOfHomework = "";
    ArrayList<ItemHomework> homeworkList;
    FloatingActionsMenu fab_homework, fab_topic, fab_exam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fab_homework = findViewById(R.id.fab_create_homework);
        fab_topic = findViewById(R.id.fab_add_topic);
        fab_exam = findViewById(R.id.fab_create_exam);

        arrayListHomework = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_homework);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //refresh function

        String[] s = listOfHomework.split(":");
        arrayListHomework.addAll(Arrays.asList(s));

        recyclerViewHomework = findViewById(R.id.recyclerViewHomework);

        homeworkList = new ArrayList<>();

        for (int i = 1; i < arrayListHomework.size()-2; i++) {
            ItemHomework itemHomework = new ItemHomework(arrayListHomework.get(i),arrayListHomework.get(i+1),arrayListHomework.get(i+2));
            homeworkList.add(itemHomework);
        }
        ListOfClassActivity.c.setItemHomework(homeworkList);
        HomeworkAdapter homeworkAdapter = new HomeworkAdapter(R.layout.item_homework,ListOfClassActivity.c.getItemHomework(),this);
        recyclerViewHomework.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewHomework.setItemAnimator(new DefaultItemAnimator());
        recyclerViewHomework.setAdapter(homeworkAdapter);


        fab_homework.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfHomeworkActivity.this,CreateHomeworkActivity.class);
            startActivity(intent);
        });

        fab_topic.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfHomeworkActivity.this,AddTopicActivity.class);
            startActivity(intent);
        });

        fab_exam.setOnClickListener(v -> {
            Intent intent = new Intent(ListOfHomeworkActivity.this,CreateExamActivity.class);
            startActivity(intent);
        });
    }



    @Override
    public void onNoteClick(int position) {
        ItemHomework itemHomework = homeworkList.get(position);
        Intent intent = new Intent(ListOfHomeworkActivity.this,ProfileHomeworkActivity.class);
        intent.putExtra("homeworkName",itemHomework.getName());
    }

}
