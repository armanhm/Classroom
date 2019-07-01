package com.example.testclassroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ProfileHomeworkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_homework);
        Intent intent = getIntent();
        String name = intent.getStringExtra("homeworkName");
        Log.e("homeworkName&&",name);
    }
}
